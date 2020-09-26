package topsea.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import topsea.blog.entity.Blog;
import topsea.blog.entity.Video;
import topsea.blog.service.BlogService;
import topsea.blog.service.VideoService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Controller
public class ResourceController {
    @Resource
    private VideoService videoService;
    @Resource
    private BlogService blogService;


    @GetMapping({"/admin/tables"})
    public String Tables(Model model) {
        Collection<Video> videos = videoService.selectAll();
        Collection<Blog> blogs = blogService.selectAllBlog();

        model.addAttribute("videos", videos);
        model.addAttribute("blogs", blogs);
        return "admin/tables";
    }

    @GetMapping({"/admin/newV"})
    public String newVideo() {
        return "admin/new_video";
    }

    @GetMapping("/admin/newV/{videoId}")
    public String editVideo(@PathVariable("videoId") Integer videoId, Model model) {
        Video video = videoService.selectById(videoId);
        model.addAttribute("video", video);
        return "admin/new_video";
    }

    @PutMapping("/admin/newV")
    public String updateVideo(Video video) {
        videoService.updateById(video);
        return "redirect:/admin/tables";
    }

    @PostMapping("/admin/newV")
    public String addVideo(Video video) {
        //写好name属性springMVC自定装配
        videoService.insertNewVideo(video);
        return "redirect:/admin/tables";
    }

    @DeleteMapping("/admin/deleteV/{videoId}")
    public String deleteVideo(@PathVariable("videoId") Integer videoId) {
        videoService.deleteById(videoId);
        return "redirect:/admin/tables";
    }

    @GetMapping("/admin/newB")
    public String newBlog() {
        return "admin/new_blog";
    }

    @GetMapping("/admin/newB/{BlogId}")
    public String editBlog(@PathVariable("BlogId") Integer BlogId, Model model) {
        Blog blog = blogService.selectBlogById(BlogId);
        model.addAttribute("blog", blog);
        return "admin/new_blog";
    }

    @PostMapping("/admin/newB")
    public String addBlog(Blog blog) {
        blogService.insertNewBLog(blog);
        return "redirect:/admin/tables";
    }

    @PutMapping("/admin/newB")
    public String updateBlog(Blog blog) {
        blogService.updateBlogById(blog);

        return "redirect:/admin/tables";
    }

    @DeleteMapping("/admin/deleteB/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Integer blogId) {
        blogService.deleteBlogById(blogId);
        return "redirect:/admin/tables";
    }
}
