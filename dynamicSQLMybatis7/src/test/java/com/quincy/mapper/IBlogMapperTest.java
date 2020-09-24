package com.quincy.mapper;

import com.quincy.pojo.Blog;
import com.quincy.utils.IDUtil;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class IBlogMapperTest {
    @Test
    public void addBlog() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IBlogMapper mapper = sqlSession.getMapper(IBlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.getId());
        blog.setTitle("Mybatis So Easy!");
        blog.setAuthor("Quincy");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("Java So Easy!");
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("Spring So Easy!");
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("微服务 So Easy!");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogsIf(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IBlogMapper mapper = sqlSession.getMapper(IBlogMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title","Spring So Easy!");
        map.put("author","Quincy");
        List<Blog> blogsList = mapper.getBlogsIf(map);
        for (Blog blog :
                blogsList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void getBlogsChoose(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IBlogMapper mapper = sqlSession.getMapper(IBlogMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title","Spring So Easy!");
        map.put("author","Quincy");
        map.put("views",9999);
        List<Blog> blogsList = mapper.getBlogsChoose(map);
        for (Blog blog :
                blogsList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IBlogMapper mapper = sqlSession.getMapper(IBlogMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("author","QuincyShen");
        map.put("id","9fc1b5c8c5a94f1f9654442ad1402b18");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogsForeach(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IBlogMapper mapper = sqlSession.getMapper(IBlogMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> ids = new ArrayList<String>();
        ids.add("cdb326f1c8ee4d41bcbc52890de5bf8a");
        map.put("ids",ids);
        List<Blog> blogList = mapper.getBlogsForeach(map);
        for (Blog blog:blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
