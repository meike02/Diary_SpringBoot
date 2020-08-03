package com.bimstart.demo.mapper;

import com.bimstart.demo.bean.userdatadata;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.*;

@Mapper
@Component
public interface userdataimp {
    @Select("select * from userdata where eamil=#{eamil}")
    public List<userdatadata> selecteamil(String eamil);
    @Insert("insert into userdata values (#{eamil},#{name},#{imgurl},1,#{dateString},0)")
    public void insert(String eamil,String name, String dateString,String imgurl);
    @Select("select * from userdata")
    public List<userdatadata> selectuserdata();
    @Insert("insert into userpassword values(#{eamil},#{password})")
    void insertpassword(String eamil, String password);
    @Select("select * from userdata where eamil=#{eamil}")
    public userdatadata selectusereamlidata(String eamil);
    @Select("select img from userdata where eamil=#{eamil}")
    public String userimgurl(String eamil);
}
