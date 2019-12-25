package com.tech.auth.user.entity;

public class UserVo {
    private String userName;
    private String userId;
    private String userPass;

    public UserVo(String userName, String userId, String userPass) {
        this.userName = userName;
        this.userId = userId;
        this.userPass = userPass;
    }

    public UserVo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String  getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userPass=" + userPass +
                '}';
    }
}
