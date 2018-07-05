package com.example.vs.vshi.utils;

public class UserInfo {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * uid
     */
    private String user_id;

    /**
     * rebate_money
     */
    private String rebate_money;

    /**
     * Paypwd
     * @return
     */
   private String pay_pwd;
    /**
     * user_info_id
     */
    private int user_info_id;

    /**
     * referee_phone
     */
    private String referee_phone;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRebate_money() {
        return rebate_money;
    }

    public void setRebate_money(String rebate_money) {
        this.rebate_money = rebate_money;
    }

    public String getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(String pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public int getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(int user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getReferee_phone() {
        return referee_phone;
    }

    public void setReferee_phone(String referee_phone) {
        this.referee_phone = referee_phone;
    }
}
