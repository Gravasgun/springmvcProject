package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 查询，对应登录功能
     *
     * @param username
     * @param password
     * @return
     */
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 新增，对应注册功能
     *
     * @param user
     * @return
     */
    int insert(User user);
}
