package com.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2016/3/25.
 */
@Entity//数据库用
public class User {

    @Id
    private String account;

    private String password;

    private String name;
    private String sex;
    private String schoolName;
    private String theClassName;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTheClassName() {
        return theClassName;
    }

    public void setTheClassName(String theClassName) {
        this.theClassName = theClassName;
    }


}
