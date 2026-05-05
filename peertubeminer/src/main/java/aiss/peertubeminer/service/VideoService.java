package aiss.peertubeminer.service;

import aiss.peertubeminer.etl.Transformer;
import aiss.peertubeminer.model.peertube.Video;
import aiss.peertubeminer.model.peertube.VideoSearch;
import aiss.peertubeminer.model.videominer.VMCaption;
import aiss.peertubeminer.model.videominer.VMComment;
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

    @Autowired
    Transformer transformer;

    @Value("${peertubeminer.baseuri}")
    String baseUri;

    /**
     * Map peertube videos to videominer videos
     *
     * @param channel     The identifier of the channel
     * @param maxVideos   The maximum number of videos to return
     * @param maxComments The maximum number of comments for each video
     * @return A list of videominer videos
     */
    public List<VMVideo> getVMVideos(String channel, Integer maxVideos, Integer maxComments) {
        String uri = baseUri + "/video-channels/" + channel + "/videos?count=" + maxVideos;

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
            String videoId = String.valueOf(v.getId());

            // Get comments and captions
            List<VMComment> vmComments = commentService.getVMComments(videoId, maxComments);
            List<VMCaption> vmCaptions = captionService.getVMCaptions(videoId);

            // Map peertube video to videominer video
            VMVideo vmVideo = transformer.transformVideo(v, vmComments, vmCaptions);

            vmVideos.add(vmVideo);
        }

        return vmVideos;
    }

    /**
     * Get videos from peerTube (for test purposes)
     * @param channel Channel to get videos from
     * @return List of videos
     */
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
