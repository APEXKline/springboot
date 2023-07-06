package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.entity.AdminUser;
import ltd.newbee.mall.dao.AdminUserMapper;
import ltd.newbee.mall.service.AdminUserService;
import ltd.newbee.mall.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    //对AdminUserService中login方法进行重写
    /**
     * 这段代码是一个登录方法，接受用户名（userName）和密码（password）作为参数。
     * 它使用了一个名为 MD5Util 的工具类来对密码进行 MD5 加密。然后，调用 adminUserMapper 的 login 方法来验证用户名和加密后的密码是否匹配，并返回相应的 AdminUser 对象。
     * 简单解释一下这段代码的逻辑：
     * 首先，使用 MD5Util.MD5Encode 方法对密码进行 MD5 加密，生成一个加密后的密码字符串。
     * 接下来，调用 adminUserMapper 的 login 方法，传入用户名和加密后的密码作为参数，以验证用户凭据的有效性。
     * adminUserMapper.login 方法将执行与数据库或其他数据存储的交互，验证用户名和密码是否匹配。
     * 最后，返回验证结果，即一个 AdminUser 对象，表示已登录的管理员用户。
     * 请确保在使用此代码之前，MD5Util 类已正确定义和导入，并且 adminUserMapper 对象已正确初始化，并且具有适当的 login 方法实现来进行数据库查询或其他相关操作。
     */

    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新名称并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }
}
