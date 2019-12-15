package com.summer.community.service;

import com.summer.community.dao.AlphaDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("singleton")//说明spring容器中有几个实例对象prototype是多例子
public class AlphaService {


    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct  //在构造方法之后调用
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy  //在销毁对象之前调用
    public void destory(){
        System.out.println("销毁AlphaService");
    }



}
