package topsea.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import topsea.blog.entity.AdminUser;
import topsea.blog.entity.Video;
import topsea.blog.mapper.AdminUserMapper;
import topsea.blog.service.VideoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class AdminController {

    @Resource
    AdminUserMapper adminUserMapper;

    @GetMapping({"/admin"})
    public String Admin() {
        return "admin/index";
    }

    @GetMapping({"/admin/charts"})
    public String Charts() {
        return "admin/blank";
    }

    @GetMapping({"/admin/forgetP"})
    public String forgetPassword() {
        return "admin/index";
    }

    @GetMapping({"/admin/register"})
    public String Register() {
        return "admin/blank";
    }

    @GetMapping({"/admin/uAnimation"})
    public String uAnimation() {
        return "admin/blank";
    }

    @GetMapping({"/admin/uBorder"})
    public String uBorder() {
        return "admin/blank";
    }

    @GetMapping({"/admin/uColor"})
    public String uColor() {
        return "admin/blank";
    }

    @GetMapping({"/admin/uOther"})
    public String uOther() {
        return "admin/blank";
    }

    @GetMapping({"/admin/login"})
    public String Login() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String AdminLogin(@RequestParam("adminEmail") String adminEmail,
                             @RequestParam("adminPassword") String adminPassword,
                             Map<String, String> map, HttpSession session) {
        AdminUser admin = adminUserMapper.selectAdminUserByEmail(adminEmail);
        session.setAttribute("alreadyLogin", admin);
        if (admin!=null && admin.getAdminPassword().equals(adminPassword)){
            return "redirect:/admin";
        }else {
            map.put("login_error", "登录信息有误,请仔细检查！");
            return "admin/login";
        }
    }

    @GetMapping({"/admin/blank"})
    public String Blank() {
        return "admin/blank";
    }


}
