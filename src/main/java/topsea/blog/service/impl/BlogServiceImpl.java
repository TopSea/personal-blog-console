package topsea.blog.service.impl;

import org.springframework.stereotype.Service;
import topsea.blog.entity.Blog;
import topsea.blog.mapper.BlogMapper;
import topsea.blog.service.BlogService;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogMapper blogMapper;

    @Override
    public Collection<Blog> selectAllBlog() {
        return blogMapper.selectAllBlog();
    }

    @Override
    public Blog selectBlogById(Integer videoId) {
        return blogMapper.selectBlogById(videoId);
    }

    @Override
    public boolean deleteBlogById(Integer videoId) {
        return blogMapper.deleteBlogById(videoId);
    }

    @Override
    public boolean updateBlogById(Blog blog) {
        return blogMapper.updateBlogById(blog);
    }

    @Override
    public boolean insertNewBLog(Blog blog) {
        return blogMapper.insertNewBLog(blog);
    }
}
