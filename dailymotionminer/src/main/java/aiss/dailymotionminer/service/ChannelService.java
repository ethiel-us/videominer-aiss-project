package aiss.dailymotionminer.service;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.User;
import aiss.dailymotionminer.model.videominer.VMChannel;
import aiss.dailymotionminer.model.videominer.VMVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VideoService videoService;

    @Autowired
    Transformer transformer;

    @Value("${dailymotion.baseuri}")
    String baseUri;

    /**
     * Map dailymotion channel to a videominer channel
     *
     * @param channelId   The identifier of the channel
     * @param maxVideos   The maximum number of videos to return
     * @param maxComments The maximum number of comments for each video
     * @return A videominer channel
     */
    public VMChannel getVMChannel(String channelId, Integer maxVideos, Integer maxComments) {
        String uri = baseUri + "/user/" + channelId + "?fields=id,screenname,description,created_time,url,avatar_720_url";

        ResponseEntity<User> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                User.class
        );

        if (response.getBody() == null) return null;

        List<VMVideo> vmVideos = videoService.getVMVideos(channelId, maxVideos, maxComments);

        User channel = response.getBody();
        vmVideos.stream().forEach(v -> v.setUser(transformer.transformUser(channel)));
        return transformer.transformChannel(channel, vmVideos);
    }

    /**
     * create a channel in videominer
     * @param channel videominer channel to be created in videominer
     * @return videominer channel
     */
    public VMChannel sendToVideominer(VMChannel channel) {
        String uri = "http://localhost:8080/videominer/channels";

        HttpEntity<VMChannel> request = new HttpEntity<>(channel);

        ResponseEntity<VMChannel> response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                request,
                VMChannel.class);

        return response.getBody();
    }
}
