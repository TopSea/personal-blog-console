package topsea.blog.service.impl;

import org.springframework.stereotype.Service;
import topsea.blog.entity.Video;
import topsea.blog.mapper.VideoMapper;
import topsea.blog.service.VideoService;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    VideoMapper videoMapper;

    @Override
    public Collection<Video> selectAll() {
        return videoMapper.selectAll();
    }

    @Override
    public Video selectById(Integer videoId) {
        return videoMapper.selectById(videoId);
    }

    @Override
    public boolean deleteById(Integer videoId) {
        return videoMapper.deleteById(videoId);
    }

    @Override
    public boolean updateById(Video video) {
        return videoMapper.updateById(video);
    }

    @Override
    public boolean insertNewVideo(Video video) {
        return videoMapper.insertNewVideo(video);
    }
}
