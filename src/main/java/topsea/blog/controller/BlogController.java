package topsea.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import topsea.blog.entity.Blog;
import topsea.blog.entity.Video;
import topsea.blog.service.BlogService;
import topsea.blog.service.VideoService;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class BlogController {
    @Resource
    private VideoService videoService;
    @Resource
    private BlogService blogService;

    @GetMapping({"/video/{videoId}"})
    public String videoDetail(Model model, @PathVariable("videoId") Integer videoId) {
        Video video = videoService.selectById(videoId);
        String videoName = video.getVideoName();
        String videoDesc = video.getVideoDesc();
        String videoSrc = video.getVideoSrc();
        model.addAttribute("video_name", videoName);
        model.addAttribute("video_desc", videoDesc);
        model.addAttribute("video_src", videoSrc);
        return "blog/topsea/video_detail";
    }

    @GetMapping({"/blog/{blogId}"})
    public String blogDetail(Model model, @PathVariable("blogId") Integer blogId) {
        Blog blog = blogService.selectBlogById(blogId);
        String blogTitle = blog.getBlogTitle();
        String blogTags = blog.getBlogTags();
        String blogContent = blog.getBlogContent();
        model.addAttribute("blog_title", blogTitle);
        model.addAttribute("blog_tags", blogTags);
        model.addAttribute("blog_content", blogContent);
        return "blog/topsea/blog_detail";
    }

    @GetMapping({"/topsea"})
    public String topsea(Model model) {
        Collection<Video> videos = videoService.selectAll();
        model.addAttribute("videos", videos);
        return "blog/topsea/resume";
    }
}
