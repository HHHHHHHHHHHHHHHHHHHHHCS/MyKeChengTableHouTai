package com;

import com.Service.KeBiaoService;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Administrator on 2016/3/4.
 */
@RestController//spring 框架必须 告诉spring 我是控制器
@EnableAutoConfiguration//spring 框架必须
@ComponentScan//需要实例化的类头上加@Autowired      类头上加@Service   这样就不用实例化了   作用是扫描
//@CrossOrigin 跨域Ajax必须
/*@CrossOrigin(origins = {"http://127.0.0.1:8020","http://localhost:63342","http://localhost:63343"}
        ,methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.POST})*/
@CrossOrigin(origins = {"*"}
        , methods = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})


public class Main
{
    @Autowired
    KeBiaoService keBiaoService;
    @Autowired
    UserService userService;


    //@RequestMapping(value = "/GetKebiaoByWeekClass",produces = "application/json;charset=UTF-8" )
    @RequestMapping("/GetKebiaoByWeekClass")
    Object GetKebiaoByWeekClass(int week, String theClassName ,String schoolName)
    {
        return this.keBiaoService.getKeBiaoByWeekClass(week, theClassName,schoolName);
    }

    @RequestMapping("/InsertClass")
    Object InsertClass(String account,String className,String teacherName,String address,int whatDay,int startTime,int length)
    {
        String result = keBiaoService.InsertClass(account, className, teacherName, address, whatDay, startTime, length);
        return result;
    }


    @RequestMapping("/Login")
    Object Login(String account, String password)
    {
        return userService.Login(account, password);
    }

    @RequestMapping("/Register")
    Object Register(String account, String password, String rePassword)
    {

        return userService.Register(account, password, rePassword);
    }

    @RequestMapping("/Forgot")
    Object Forgot(String account, String password, String rePassword) {
        return userService.ForgotPassword(account, password, rePassword);
    }

    @RequestMapping("/GetTest")
    Object GetTest() {
        return NewStr1;
    }

    @RequestMapping("/PostTest")
    Object PostTest(int number)
    {
        if(number==1)
        {
            return NewStr1;
        }
        else
        {
            return NewStr2;
        }
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Main.class, args);
    }

    private static final String NewStr1 = "{\n" +
            "\t\"data\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"className\": \"课名1\",\n" +
            "\t\t\t\"teacherName\": \"教师1\",\n" +
            "\t\t\t\"address\":\"法国\",\n" +
            "\t\t\t\"whatDay\": 1,\n" +
            "\t\t\t\"start\": 1,\n" +
            "\t\t\t\"length\": 3\n" +
            "\t\t}\n" +
            "\t\t, {\n" +
            "\t\t\t\"className\": \"课名2\",\n" +
            "\t\t\t\"teacherName\": \"教师2\",\n" +
            "\t\t\t\"address\":\"美国\",\n" +
            "\t\t\t\"whatDay\": 4,\n" +
            "\t\t\t\"start\": 2,\n" +
            "\t\t\t\"length\": 3\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}\n";

    private static final String NewStr2 = "{\n" +
            "\t\"data\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"className\": \"课名3\",\n" +
            "\t\t\t\"teacherName\": \"教师3\",\n" +
            "\t\t\t\"address\":\"法国\",\n" +
            "\t\t\t\"whatDay\": 3,\n" +
            "\t\t\t\"start\": 3,\n" +
            "\t\t\t\"length\": 3\n" +
            "\t\t}\n" +
            "\t\t, {\n" +
            "\t\t\t\"className\": \"课名4\",\n" +
            "\t\t\t\"teacherName\": \"教师4\",\n" +
            "\t\t\t\"address\":\"美国\",\n" +
            "\t\t\t\"whatDay\": 5,\n" +
            "\t\t\t\"start\": 4,\n" +
            "\t\t\t\"length\": 3\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}\n";

}
