package com.summer.community.dao;


import com.summer.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//被容器扫描到 自动实现 装配
public interface DiscussPostMapper {

    //查询帖子（所有和个人（uerId））  offset起始行的行号  limit每一页最多显示多少条数据
    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);

    //查询表里一共有多少数据 param给参数取别名
    //如果需要动态的拼一个<if>参数 并且方法只有一个参数  这个参数必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);






}
