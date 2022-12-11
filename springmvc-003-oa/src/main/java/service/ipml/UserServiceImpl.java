package service.ipml;

import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user, String username, String password) {
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int register(User user) {
        int count = userMapper.insert(user);
        return count;
    }

    @Override
    public void setCookies(HttpServletRequest request, HttpServletResponse response, int day) {
        //登录成功了，并且选择了"十天内免登录"功能
        String value = request.getParameter("f");
        if ("1".equals(value)) {
            //创建cookie存储用户名
            Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
            //创建cookie存储密码
            Cookie passwordCookie = new Cookie("password", request.getParameter("password"));
            //设置cookie的有效时间
            usernameCookie.setMaxAge(60 * 60 * 24 * day);
            passwordCookie.setMaxAge(60 * 60 * 24 * day);
            //设置cookie的path，只要访问这个应用，浏览器就一定要携带这两个cookie
            usernameCookie.setPath(request.getContextPath());
            passwordCookie.setPath(request.getContextPath());
            //响应cookie给浏览器
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
    }

    @Override
    public void exit(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        if (session != null) {
            //从session域中删除user对象
            session.removeAttribute("user");
            //手动销毁session对象
            session.invalidate();
        }

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name) || "password".equals(name)) {
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
            }
        }
    }

}
