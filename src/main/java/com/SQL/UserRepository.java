package com.SQL;

import com.Data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/3/25.
 */
@Repository//SQL查询用
public interface UserRepository extends CrudRepository<User,String>
{
    //@Query(value = "select applicationEntity from ApplicationEntity applicationEntity where applicationEntity.PartNumber=:PartNumber")
    //public List findByPartNumber(@Param("PartNumber") String partNumber);
}
