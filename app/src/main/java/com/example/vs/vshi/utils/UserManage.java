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
    public void saveUserInfo(Context context, String username, String password,String user_id,String token) {
        //Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.putString("USER_ID",user_id);
        editor.putString("TOKEN",token);
        editor.commit();
    }

     public void cleanSp(Context context){
        sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
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
        userInfo.setUser_id(sp.getString("USER_ID",""));
        userInfo.setToken(sp.getString("TOKEN",null));
        return userInfo;
    }



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
