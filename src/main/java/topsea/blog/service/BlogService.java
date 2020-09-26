package topsea.blog.service;

import topsea.blog.entity.Blog;

import java.util.Collection;

public interface BlogService {
    Collection<Blog> selectAllBlog();

    Blog selectBlogById(Integer videoId);

    boolean deleteBlogById(Integer videoId);

    boolean updateBlogById(Blog blog);

    boolean insertNewBLog(Blog blog);
}
