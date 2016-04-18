package com.SQL;

/**
 * Created by Administrator on 2016/3/24.
 */

import com.Data.Ke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//SQL查询用
public interface KeBiaoRepository extends CrudRepository<Ke,String>
{
    /**
     * 根据班级名字和学校名字返回课程
     * @param theClassName 班级名字
     * @param schoolName 学校名字
     * @return 课程
     */
    List<Ke> findByTheClassNameAndSchoolName(String theClassName, String schoolName);
}
