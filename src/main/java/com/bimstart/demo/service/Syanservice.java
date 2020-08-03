package com.bimstart.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Syanservice {
    @Async
    public void test(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理中...");
    }
//    @Scheduled(cron = "0/4 * * * * MON-SAT")
//    public void test1(){
//        System.out.println("测试");
//    }
}
