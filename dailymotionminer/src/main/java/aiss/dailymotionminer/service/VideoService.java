package aiss.dailymotionminer.service;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.dailymotion.VideoSearch;
import aiss.dailymotionminer.model.videominer.VMCaption;
import aiss.dailymotionminer.model.videominer.VMComment;
import aiss.dailymotionminer.model.videominer.VMVideo;
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
    TagService tagService;

    @Autowired
    SubtitleService subtitleService;

    @Autowired
    Transformer transformer;

    @Value("${dailymotion.baseuri}")
    String baseUri;

    /**
     * Map dailymotion videos to videominer videos
     *
     * @param channel     The identifier of the channel
     * @param maxVideos   The maximum number of videos to return
     * @param maxComments The maximum number of comments for each video
     * @return A list of videominer videos
     */
    public List<VMVideo> getVMVideos(String channel, Integer maxVideos, Integer maxComments) {
        String uri = baseUri + "/user/" + channel + "/videos?limit=" + maxVideos + "&fields=id,title,description,created_time";

        List<VMVideo> vmVideos = new ArrayList<>();
        List<Video> ptVideos;

        ResponseEntity<VideoSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                VideoSearch.class
        );

        if (response.getBody() == null || response.getBody().getList() == null) {
            return new ArrayList<>();
        }

        ptVideos = response.getBody().getList();
        for (Video v : ptVideos) {
            String videoId = String.valueOf(v.getId());

            // Get comments and captions
            List<VMComment> vmComments = tagService.getVMComments(videoId, maxComments);
            vmComments.forEach(c -> c.setCreatedOn(v.getCreated_time().toString()));
            List<VMCaption> vmCaptions = subtitleService.getVMCaptions(videoId);

            // Map dailymotion video to videominer video
            VMVideo vmVideo = transformer.transformVideo(v, vmComments, vmCaptions);

            vmVideos.add(vmVideo);
        }

        return vmVideos;
    }

    public List<Video> getDMVideos(String channel) {
        String uri = baseUri + channel + "/videos";

        ResponseEntity<VideoSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                VideoSearch.class
        );
        if (response.getBody() != null) {
            return response.getBody().getList();
        } else {
            return new ArrayList<>();
        }
    }
}
