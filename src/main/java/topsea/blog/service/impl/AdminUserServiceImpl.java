package topsea.blog.service.impl;

import org.springframework.stereotype.Service;
import topsea.blog.entity.AdminUser;
import topsea.blog.mapper.AdminUserMapper;
import topsea.blog.service.AdminUserService;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    AdminUserMapper adminUserMapper;

    @Override
    public Collection<AdminUser> selectAllAdminUser() {
        return adminUserMapper.selectAllAdminUser();
    }

    @Override
    public AdminUser selectAdminUserByEmail(String adminEmail) {
        return adminUserMapper.selectAdminUserByEmail(adminEmail);
    }

    @Override
    public boolean deleteAdminUserById(Integer adminId) {
        return adminUserMapper.deleteAdminUserById(adminId);
    }

    @Override
    public boolean updateAdminUserById(AdminUser adminUser) {
        return adminUserMapper.updateAdminUserById(adminUser);
    }

    @Override
    public boolean insertNewAdminUser(AdminUser adminUser) {
        return adminUserMapper.insertNewAdminUser(adminUser);
    }
}
