package topsea.blog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import topsea.blog.entity.AdminUser;

import java.util.Collection;

public interface AdminUserMapper {

    @Select("select * from admin_user")
    Collection<AdminUser> selectAllAdminUser();

    @Select("select * from admin_user where admin_email = #{adminEmail}")
    AdminUser selectAdminUserByEmail(String adminEmail);

    @Delete("delete from admin_user where admin_id = #{adminId}")
    boolean deleteAdminUserById(Integer adminId);

    @Update("update admin_user set blog_title = #{blogTitle}, blog_tags = #{blogTags}," +
            " blog_content = #{blogContent} where admin_id = #{adminId}")
    boolean updateAdminUserById(AdminUser adminUser);

    @Insert("insert into admin_user(blog_title, blog_tags, blog_content) value(#{blogTitle}," +
            "#{blogTags}, #{blogContent})")
    boolean insertNewAdminUser(AdminUser adminUser);
}
