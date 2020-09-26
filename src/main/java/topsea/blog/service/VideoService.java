package topsea.blog.service;

import topsea.blog.entity.Video;

import java.util.Collection;

public interface VideoService {

    Collection<Video> selectAll();

    Video selectById(Integer videoId);

    boolean deleteById(Integer videoId);

    boolean updateById(Video video);

    boolean insertNewVideo(Video video);
}
