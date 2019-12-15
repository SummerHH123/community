package com.summer.community.controller;


import com.summer.community.entity.DiscussPost;
import com.summer.community.entity.Page;
import com.summer.community.entity.User;
import com.summer.community.service.DiscussPostService;
import com.summer.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index" ,method = RequestMethod.GET)
    //响应的是网页  不需要写@RequestBody
    public String getIndexPage(Model model, Page page){
        //方法调用之前 ，springmvc会自动实例化Model和Page，并将Page注入Model
        //所以，在thymleaf中可以直接访问page的属性
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");




        if (page.getCurrent()>page.getTotal()){
            page.setCurrent(page.getTotal());
        }
        List<DiscussPost> list = discussPostService.findDiscussPost(0, page.getoffset(), page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if (list!=null){
            for (DiscussPost discussPost : list) {
                Map<String,Object> map=new HashMap<>();
                map.put("post",discussPost);
                User user = userService.findUserById(discussPost.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
