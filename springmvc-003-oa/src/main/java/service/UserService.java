package service;

import bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 登录功能
     *
     * @param user
     * @param username
     * @param password
     * @return
     */
    boolean login(User user, String username, String password);

    /**
     * 注册功能
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 设置cookie，免登录功能
     *
     * @param request
     * @param response
     * @param day
     */
    void setCookies(HttpServletRequest request, HttpServletResponse response, int day);

    /**
     * 退出功能，清除cookie和session
     *
     * @param request
     * @param response
     */
    void exit(HttpServletRequest request, HttpServletResponse response);
}
