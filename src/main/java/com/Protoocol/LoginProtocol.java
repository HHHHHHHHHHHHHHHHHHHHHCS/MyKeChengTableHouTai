package com.Protoocol;

/**
 * Created by Administrator on 2016/3/25.
 */
public class LoginProtocol
{
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";//登录成功
    public static final String LOGIN_FAIL = "LOGIN_FAIL";//登录失败

    public static final String RES_SUCCESS = "RES_SUCCESS";//注册成功
    public static final String RES_FAIL_ACCOUNT = "RES_FAIL_ACCOUNT";//注册失败，帐号存在
    public static final String RES_FAIL_PASS = "RES_FAIL_PASS";//注册失败，密码格式错误
    public static final String RES_FAIL_REPASS = "RES_FAIL_REPASS";//注册失败，两次密码应该一致

    public static final String FORGOT_SUCCESS = "FORGOT_SUCCESS";//修改成功
    public static final String FORGOT_FAIL_ACCOUNT = "FORGOT_FAIL_ACCOUNT";//修改失败，帐号没有注册
    public static final String FORGOT_FAIL_PASS = "FORGOT_FAIL_PASS";//修改失败，密码格式错误
    public static final String FORGOT_FAIL_REPASS = "FORGOT_FAIL_REPASS";//修改失败，两次密码应该一致

}
