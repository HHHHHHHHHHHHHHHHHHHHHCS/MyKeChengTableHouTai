package com.Service;

import com.Data.Ke;
import com.Data.User;
import com.Protoocol.KeProtocol;
import com.SQL.KeBiaoRepository;
import com.SQL.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/3/18.
 */
@Service//自动实例化用
public class KeBiaoService
{
    @Autowired
    private KeBiaoRepository keBiaoRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据周和班级，返回课表
     * @param week
     * @param theClassName
     * @param schoolName
     * @return
     */
    public List getKeBiaoByWeekClass(int week, String theClassName,String schoolName)
    {
        List<Ke> list = keBiaoRepository.findByTheClassNameAndSchoolName(theClassName,schoolName);
        List<Ke> newList = new ArrayList<Ke>();
        for (Ke newKe:list) {
            if(newKe.getStartWeek()<=week&&week<=newKe.getEndWeek())
            {
                newList.add(newKe);
            }
        }
        return  newList;
    }


    /**
     * 保存课
     * @param className
     * @param teacherName
     * @param address
     * @param whatDay
     * @param startTime
     * @param length
     */
    public String InsertClass(String account,String className,String teacherName,String address,int whatDay,int startTime,int length)
    {
        User user = userRepository.findOne(account);

        if(user==null)
        {
            return KeProtocol.KE_INSERT_FAIL;
        }

        String uuid = UUID.randomUUID().toString();

        Ke newKe= new Ke();
        newKe.setId(uuid);
        newKe.setClassName(className);
        newKe.setTeacherName(teacherName);
        newKe.setClassName(className);
        newKe.setAddress(address);
        newKe.setWhatDay(whatDay);
        newKe.setStartTime(startTime);
        newKe.setLength(length);

        newKe.setSchoolName(user.getSchoolName());
        newKe.setTheClassName(user.getTheClassName());
        try
        {
            keBiaoRepository.save(newKe);
        }
        catch (Exception e)
        {
            return KeProtocol.KE_INSERT_FAIL;
        }
        return  KeProtocol.KE_INSERT_SUCCESS;
    }

}
