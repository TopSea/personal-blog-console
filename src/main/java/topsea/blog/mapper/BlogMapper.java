package topsea.blog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import topsea.blog.entity.Blog;

import java.util.Collection;

public interface BlogMapper {
    @Select("select * from ts_blog")
    Collection<Blog> selectAllBlog();

    @Select("select * from ts_blog where blog_id = #{blogId}")
    Blog selectBlogById(Integer videoId);

    @Delete("delete from ts_blog where blog_id = #{blogId}")
    boolean deleteBlogById(Integer videoId);

    @Update("update ts_blog set blog_title = #{blogTitle}, blog_tags = #{blogTags}," +
            " blog_content = #{blogContent} where blog_id = #{blogId}")
    boolean updateBlogById(Blog blog);

    @Insert("insert into ts_blog(blog_title, blog_tags, blog_content) value(#{blogTitle}," +
            "#{blogTags}, #{blogContent})")
    boolean insertNewBLog(Blog blog);
}
