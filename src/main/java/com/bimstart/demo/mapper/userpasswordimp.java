package com.bimstart.demo.mapper;

import com.bimstart.demo.bean.userpassworddata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.*;

@Mapper
@Component
public interface userpasswordimp {
    @Select("select * from userpassword where eamil=#{eamil} and password = #{password}")
    public List<userpassworddata> selectuserdataword(String eamil,String password);
}
