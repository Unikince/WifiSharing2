package com.lvqingyang.wifisharing.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Author：LvQingYang
 * Date：2017/8/26
 * Email：biloba12345@gamil.com
 * Github：https://github.com/biloba123
 * Info：
 */
public class User extends BmobUser {
    private String nick;
    private Boolean sex; //性别（未设置：null ; 男：true）
    private BmobFile avater;//头像
    private BmobDate birthday;
    private Integer credit;
    private static final String TAG = "User";

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public BmobFile getAvater() {
        return avater;
    }

    public void setAvater(BmobFile avater) {
        this.avater = avater;
    }

    public BmobDate getBirthday() {
        return birthday;
    }

    public void setBirthday(BmobDate birthday) {
        this.birthday = birthday;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public static void register(final String tel, final String smsCode, final String password,
                                final SaveListener<User> lis){
        User user = new User();
        user.setMobilePhoneNumber(tel);//设置手机号码（必填）
        user.setPassword(password);                  //设置用户密码
        user.setNick(tel);
        user.signOrLogin(smsCode, lis);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @param lis
     */
    public static void login(String userName,String password,LogInListener<User> lis){
        BmobUser.loginByAccount(userName, password, lis);
    }

    /**
     * 退出登录
     */
    public static void logout(){
        BmobUser.logOut();   //清除缓存用户对象
    }


}