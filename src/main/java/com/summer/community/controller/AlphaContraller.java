package com.summer.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaContraller {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring boot.";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+" "+value);
        }

        System.out.println(request.getParameter("code"));

        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        try(
                //获取输出流  底层自己建好
                PrintWriter printWriter=response.getWriter();
                ) {

            printWriter.write("<h1>coder</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //处理请求数据
    //GET  希望向服务器获取某些数据
    //查询学生记录 当前页 最大显示条数  /student?current=1&limit=20
    @RequestMapping(path = "/student",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){

        System.out.println(current);
        System.out.println(limit);
        return "some students";

    }

    //根据学生编号  查询一个学生
    //   /student/123

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //post请求
    //
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStuden(String name,//与form表单中的name名字一致  就不用@RequestParam注解
                             int age){
        System.out.println(name);
        System.out.println(age);

        return "success";

    }

    //响应html数据
    //查询老师

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    //所有的组件都是由dispatcherServlet调度的，dispatcherServlet会调用Controller
    //的某一个方法 方法返回model数据，再给模板引擎 生成html
    public ModelAndView getTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","战三");
        modelAndView.addObject("age","54");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }


    @RequestMapping(path = "/school",method = RequestMethod.GET)
    //返回类型写成String  存的是路径   有了view了
    //还差model，在参数里声明
    public String getSchool(Model model){
        model.addAttribute("name","情话");
        model.addAttribute("age","60");


        return "/demo/view";
    }

    //响应json数据(一般是在异步请求) 返回局部验证的结果
    //java对象 通过json字符串 解析对象 转换成js对象

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody  //返回json
    public Map<String,Object> getEmp(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("salary",8000.00);
        return map;
    }

    //返回多个相似结构
    //查询所有员工
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody  //返回json
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> li=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("salary",8000.00);

        li.add(map);

        Map<String,Object> emp=new HashMap<>();

        emp.put("name","水电费");
        emp.put("age",45);
        emp.put("salary",8000.00);
        li.add(emp);



        return li;
    }


}
