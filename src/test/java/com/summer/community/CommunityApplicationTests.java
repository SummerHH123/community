package com.summer.community;

import com.summer.Community1Application;
import com.summer.community.dao.AlphaDao;
import com.summer.community.dao.UserMapper;
import com.summer.community.entity.User;
import com.summer.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = Community1Application.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext ac;


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ac=applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(ac);
//		在容器中查找是否有alphadao这个类

		AlphaDao alphaDao=ac.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());


		alphaDao = ac.getBean("aplphaDao",AlphaDao.class);
		System.out.println(alphaDao.select());
	}


	@Test
	public void testBeanManagement(){
		AlphaService alphaService=ac.getBean(AlphaService.class);

		System.out.println(alphaService);

	}

	@Test
	public void testConfig(){
		SimpleDateFormat simpleDateFormat=ac.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

		SimpleDateFormat simpleDateFormat1=ac.getBean("simpleDateFormat66",SimpleDateFormat.class);
		System.out.println(simpleDateFormat1.format(new Date()));
	}

	@Autowired  //依赖注入
	@Qualifier("aplhaDaoMyBatisImpl")//根据名字来注入
	private AlphaDao alphaDao;
	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}




}
