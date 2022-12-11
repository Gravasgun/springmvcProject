package controller;

import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    /**
     * 登录功能
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userMapper.select(username, password);
        //判断是否登录成功
        boolean login = false;
        login = userService.login(user, username, password);
        if (login) {
            //设置cookie(十天内免登陆功能)
            userService.setCookies(request, response, new Integer(10));
            //获取session(登录功能)
            request.getSession().setAttribute("user",user);
            return "redirect:/dept/display";
        } else {
            return "redirect:/jsp/loginError.jsp";
        }
    }

    /**
     * 注册功能
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user) {
        int count = userService.register(user);
        if (count == 1) {
            return "redirect:/index.jsp";
        } else {
            return "redirect:/jsp/loginError.jsp";
        }
    }

    /**
     * 免登录功能
     *
     * @param request
     * @return
     */
    @RequestMapping("/controlPages")
    public String controlPages(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)) {
                    username = cookie.getValue();
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                }
            }
        }

        if (username != null && password != null && request.getSession().getAttribute("user") != null) {
            //连接数据库
            User user = userMapper.select(username, password);
            if (user != null) {
                //获取session对象
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "redirect:/dept/display";
            } else {
                return "redirect:/jsp/error.jsp";
            }
        } else {
            return "redirect:/index.jsp";
        }
    }

    /**
     * 退出功能
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) {
        userService.exit(request, response);
        return "redirect:/user/controlPages";
    }


}
