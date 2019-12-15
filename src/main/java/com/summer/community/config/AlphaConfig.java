package com.summer.community.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {

    @Bean  //方法名就是bean的名字  方法放回的对象将被装配到容器里
    public SimpleDateFormat simpleDateFormat66(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }


}
