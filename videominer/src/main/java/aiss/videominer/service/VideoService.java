package aiss.videominer.service;


import aiss.videominer.model.Caption;
import aiss.videominer.model.Comment;
import aiss.videominer.model.Video;
import aiss.videominer.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(String id) {
        Optional<Video> video = videoRepository.findById(id);
        return video.orElse(null);
    }

    public List<Comment> getCommentsFromVideo(String id) {
        Video video = videoRepository.findById(id).orElse(null);
        return video != null ? video.getComments() : null;
    }

    public List<Caption> getCaptionsFromVideo(String id) {
        Video video = videoRepository.findById(id).orElse(null);
        return video != null ? video.getCaptions() : null;
    }

    //  public Video updateVideo(Video video) { return videoRepository.save(video);}

    // public void deleteVideo(String id) { videoRepository.deleteById(id);}
}
