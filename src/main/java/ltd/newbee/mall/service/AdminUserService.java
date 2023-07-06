package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.AdminUser;

public interface AdminUserService {

    //login 方法是一个登录函数，它接受两个参数：userName（用户名）和 password（密码）。
    // 它返回一个 AdminUser 对象，用于表示已登录的管理员用户。
    AdminUser login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param loginUserId
     * @return
     */
    AdminUser getUserDetailById(Integer loginUserId);

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId
     * @param loginUserName
     * @param nickName
     * @return
     */
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

}
