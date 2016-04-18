package com.Service;

import com.Data.User;
import com.Protoocol.LoginProtocol;
import com.SQL.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/3/25.
 */
@Service//自动实例化用
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    /**
     * 登录
     * @param account 帐号
     * @param password 密码
     * @return 登录结果
     */
    public String  Login(String account,String password)
    {
        User newUser = userRepository.findOne(account);
        if(newUser==null||!newUser.getPassword().equals(password))
        {
            return LoginProtocol.LOGIN_FAIL;
        }
        return LoginProtocol.LOGIN_SUCCESS;
    }

    /**
     * 注册
     * @param account 帐号
     * @param password 密码
     * @return 注册情况
     */
    public String Register(String account,String password,String rePassword)
    {
        if(account==null||account.equals(""))
        {
            return LoginProtocol.RES_FAIL_ACCOUNT;
        }
        else if(password==null||password.equals(""))
        {
            return LoginProtocol.RES_FAIL_PASS;
        }
        else if(!password.equals(rePassword))
        {
            return LoginProtocol.RES_FAIL_REPASS;
        }
        else
        {
            if(userRepository.findOne(account)!=null)
            {
                return LoginProtocol.RES_FAIL_ACCOUNT;
            }
            User newAccount = new User();
            newAccount.setAccount(account);
            newAccount.setPassword(password);
            userRepository.save(newAccount);
        }
        return LoginProtocol.RES_SUCCESS;
    }

    /**
     * 忘记密码
     * @param account 帐号
     * @param password 密码
     * @param rePassword 重复密码
     * @return 密码情况
     */
    public String ForgotPassword(String account,String password,String rePassword)
    {
        if(account==null||account.equals(""))
        {
            return LoginProtocol.FORGOT_FAIL_ACCOUNT;
        }
        else if(password==null||password.equals(""))
        {
            return LoginProtocol.FORGOT_FAIL_PASS;
        }
        else if(!password.equals(rePassword))
        {
            return LoginProtocol.FORGOT_FAIL_REPASS;
        }
        else
        {
            User oldUser= userRepository.findOne(account);
            if(oldUser==null)
            {
                return LoginProtocol.FORGOT_FAIL_ACCOUNT;
            }
            oldUser.setPassword(password);
            userRepository.save(oldUser);
        }
        return LoginProtocol.FORGOT_SUCCESS;
    }
}
