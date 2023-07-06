package ltd.newbee.mall.entity;

import java.util.Objects;

public class AdminUser {
    private Integer adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public AdminUser() {
    }

    public Integer getAdminUserId() {
        return adminUserId;

    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "adminUserId=" + adminUserId +
                ", loginUserName='" + loginUserName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", locked=" + locked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminUser adminUser = (AdminUser) o;
        return Objects.equals(adminUserId, adminUser.adminUserId) && Objects.equals(loginUserName, adminUser.loginUserName) && Objects.equals(loginPassword, adminUser.loginPassword) && Objects.equals(nickName, adminUser.nickName) && Objects.equals(locked, adminUser.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminUserId, loginUserName, loginPassword, nickName, locked);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}