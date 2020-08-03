package com.bimstart.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface userdiaryimp {
    @Insert("insert userdiary values(#{eamil},#{diaryurl},#{overt},#{lovepeoples})")
    public void insert(String eamil,String diaryurl ,boolean overt,Integer lovepeoples);
}
