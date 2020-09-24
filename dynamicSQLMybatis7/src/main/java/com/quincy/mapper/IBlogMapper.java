package com.quincy.mapper;

import com.quincy.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface IBlogMapper {
//    插入数据
    void addBlog(Blog blog);

    //查询博客
    List<Blog> getBlogsIf(Map map);

    //查询博客
    List<Blog> getBlogsChoose(Map map);

    //更新博客
    void updateBlog(Map map);

    //查询foreach
    List<Blog> getBlogsForeach(Map map);
}
