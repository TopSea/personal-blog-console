package topsea.blog.service;

import topsea.blog.entity.AdminUser;

import java.util.Collection;

public interface AdminUserService {

    Collection<AdminUser> selectAllAdminUser();

    AdminUser selectAdminUserByEmail(String adminEmail);

    boolean deleteAdminUserById(Integer adminId);

    boolean updateAdminUserById(AdminUser adminUser);

    boolean insertNewAdminUser(AdminUser adminUser);
}
