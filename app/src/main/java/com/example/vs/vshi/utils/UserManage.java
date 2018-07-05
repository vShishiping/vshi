package com.example.vs.vshi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class UserManage {
    private static UserManage instance;
    private SharedPreferences sp;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, String username, String password,String user_id,String rebate_money,String pay_pwd,int user_info_id,String referee_phone,String token) {
        //Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.putString("USER_ID",user_id);
        editor.putString("REBATE_MONEY",rebate_money);
        editor.putString("PAY_PWD",pay_pwd);
        editor.putInt("USER_INFO_ID",user_info_id);
        editor.putString("REFEREE_PHONE",referee_phone);
        editor.putString("TOKEN",token);
        editor.commit();
    }

    public void saveShopping(Context context,String goodsName,int num,String shopName){
        sp = context.getSharedPreferences("order",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("GOODSNAME",goodsName);
        editor.putInt("NUM",num);
        editor.putString("SHOPNAME",shopName);
        editor.commit();
    }
     public void cleanSp(Context context){
        sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
         SharedPreferences.Editor edit = sp.edit();
         edit.clear();
        edit.commit();

     }

    public void cleanSp2(Context context){
        sp = context.getSharedPreferences("order",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.commit();

    }
    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public UserInfo getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(sp.getString("USER_NAME", ""));
        userInfo.setPassword(sp.getString("PASSWORD", ""));
        userInfo.setReferee_phone(sp.getString("REFEREE_PHONE",""));
        userInfo.setUser_id(sp.getString("USER_ID",""));
        userInfo.setRebate_money(sp.getString("REBATE_MONEY",""));
        userInfo.setPay_pwd(sp.getString("PAY_PWD",""));
        userInfo.setUser_info_id(sp.getInt("USER_INFO_ID",0));
        userInfo.setToken(sp.getString("TOKEN",null));
        return userInfo;
    }

//    public ShopInfo getShopInfo(Context context){
//        SharedPreferences sp = context.getSharedPreferences("order", Context.MODE_PRIVATE);
//        ShopInfo shopInfo = new ShopInfo();
//        shopInfo.setGoodsName(sp.getString("GOODSNAME",""));
//        shopInfo.setNum(sp.getInt("NUM",0));
//        shopInfo.setShopName(sp.getString("SHOPNAME",""));
//        return shopInfo;
//    }

    /**
     * userInfo中是否有数据
     */
    public boolean hasUserInfo(Context context) {
        UserInfo userInfo = getUserInfo(context);
        if (userInfo != null) {
            if ((!TextUtils.isEmpty(userInfo.getUserName())) && (!TextUtils.isEmpty(userInfo.getPassword()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
