package com.bimstart.demo.service;

import com.bimstart.demo.bean.wetnessdata;
import com.bimstart.demo.mapper.wetnessimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Testservice {
    @Autowired
    public wetnessimp data;
    @Cacheable(value = {"temp"},key="#root.args[0]",condition = "#root.args[0]>'xiaohua'")
    public List<wetnessdata> shuju(String name){
        System.out.println("yi"+name);
        return data.getshuju(name);
    }
    @CachePut(value = {"temp"},key = "#name")
    public String updata(String name){
        System.out.println("update"+name);
        data.update(name);
        return name;
    }
    @CacheEvict(value = "temp",key = "#name")
    public void delete(String name){
        System.out.println("delete"+name);
    }
}
