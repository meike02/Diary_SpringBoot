package com.bimstart.demo.mapper;

import com.bimstart.demo.bean.wetnessdata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface wetnessimp {
    @Select("select * from userdata where name=#{name}")
    public List<wetnessdata> getshuju(String name);
    @Update("update userdata set nickname='update' where name=#{name}")
    public void update(String name);
}
