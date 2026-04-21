package aiss.peertubeminer.service;

import aiss.peertubeminer.model.peertube.User;
import aiss.peertubeminer.model.peertube.Video;
import aiss.peertubeminer.model.peertube.VideoSearch;
import aiss.peertubeminer.model.videominer.VMCaption;
import aiss.peertubeminer.model.videominer.VMComment;
import aiss.peertubeminer.model.videominer.VMUser;
import aiss.peertubeminer.model.videominer.VMVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentService commentService;

    @Autowired
    CaptionService captionService;

    @Value("${peertubeminer.baseuri}")
    String baseUri;

    /**
     * Map peeertube videos to videominer videos
     * @param channel The identifier of the channel
     * @param maxVideos The maximum number of videos to return
     * @param maxComments The maximum number of comments for each video
     * @return A list of videominer videos
     */
    public List<VMVideo> getVMVideos(String channel, Integer maxVideos, Integer maxComments) {
        String uri = baseUri + "/video-channels/" + channel + "/videos?count=" + String.valueOf(maxVideos);
        List<VMVideo> vmVideos = new ArrayList<>();
        List<Video> ptVideos;

        ResponseEntity<VideoSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                VideoSearch.class
        );

        if (response.getBody() == null || response.getBody().getData() == null) {
            return new ArrayList<>();
        }
        ptVideos = response.getBody().getData();

        for (Video v : ptVideos) {
            String videoId = v.getId().toString();

            // Map peertube user to videominer user
            User ptUser = v.getUser();
            VMUser vmUser = VMUser.of(
                   String.valueOf(ptUser.getId()),
                    ptUser.getDisplayName(),
                    ptUser.getUrl(),
                    ptUser.getAvatars().getFirst().getFileUrl()

            );

            // Get comments and captions
            List<VMComment> vmComments = commentService.getVMComments(videoId, maxComments);
            List<VMCaption> vmCaptions = captionService.getVMCaptions(videoId);

            // Map peertube video to videominer video
            VMVideo vmVideo = VMVideo.of(
                    String.valueOf(v.getId()),
                    v.getName(),
                    v.getDescription(),
                    v.getCreatedAt(),
                    vmUser
            );

            vmVideo.setComments(vmComments);
            vmVideo.setCaptions(vmCaptions);
            vmVideos.add(vmVideo);
        }

        return vmVideos;
    }

    public List<Video> getPTVideos(String channel) {
        String uri = baseUri + "/video-channels/" + channel + "/videos";

        ResponseEntity<VideoSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                VideoSearch.class
        );
        if (response.getBody() != null) {
            return response.getBody().getData();
        } else {
            return new ArrayList<>();
        }
    }
}
