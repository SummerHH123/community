package com.summer.community;


import com.summer.Community1Application;
import com.summer.community.dao.DiscussPostMapper;
import com.summer.community.dao.UserMapper;

import com.summer.community.entity.DiscussPost;
import com.summer.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = Community1Application.class)
public class MapperTests {



    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);

        user=userMapper.selectByName("liubei");
        System.out.println(user);

        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("326857289@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows=userMapper.updateHeader(150,"http://www.nowcoder.com/101.png");
        System.out.println(rows);

        userMapper.updatePassword(150,"6666");
        System.out.println(rows);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPost(0, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }







}
