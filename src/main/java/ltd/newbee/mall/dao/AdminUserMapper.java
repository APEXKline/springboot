package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    /**
     *
     * 这个方法是一个登录函数，它有两个参数：userName（用户名）和 password（密码）。使用@Param注解来标识参数的名称。
     * 这个方法的返回类型是AdminUser，表示已登录的管理员用户。
     */

    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);
    int updateByPrimaryKey(AdminUser record);
}