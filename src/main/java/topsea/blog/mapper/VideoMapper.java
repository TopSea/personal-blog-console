package topsea.blog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import topsea.blog.entity.Video;

import java.util.Collection;

public interface VideoMapper {

    @Select("select * from ts_video")
    Collection<Video> selectAll();

    @Select("select * from ts_video where video_id = #{videoId}")
    Video selectById(Integer videoId);

    @Select("select * from ts_video limit 0,2")
    Collection<Video> videoToShow();

    @Delete("delete from ts_video where video_id = #{videoId}")
    boolean deleteById(Integer videoId);

    @Update("update ts_video set video_name = #{videoName}, video_desc = #{videoDesc}," +
            " video_src = #{videoSrc} where video_id = #{videoId}")
    boolean updateById(Video video);

    @Insert("insert into ts_video(video_name, video_desc, video_src) value(#{videoName}," +
            "#{videoDesc}, #{videoSrc})")
    boolean insertNewVideo(Video video);

}

