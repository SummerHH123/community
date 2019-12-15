package com.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		//自动的创建了spring容器
		SpringApplication.run(CommunityApplication.class, args);
	}


}
