package cn.prv.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import cn.prv.bean.User;

@Mapper
@Component
public interface UserMapper {
    
    @Select("select * from user where id=#{id}")
    @Results(id="userMap",value= {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "gender", column = "gender", javaType = String.class)
    })
    User queryUserById(@Param("id") int id);
    
}
