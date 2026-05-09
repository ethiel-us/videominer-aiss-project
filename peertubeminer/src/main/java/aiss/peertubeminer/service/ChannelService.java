package aiss.peertubeminer.service;

import aiss.peertubeminer.etl.Transformer;
import aiss.peertubeminer.exception.ChannelNotFoundException;
import aiss.peertubeminer.exception.VideoMinerCommunicationException;
import aiss.peertubeminer.model.peertube.Channel;
import aiss.peertubeminer.model.videominer.VMChannel;
import aiss.peertubeminer.model.videominer.VMVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
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

    @Value("${peertubeminer.baseuri}")
    String baseUri;

    @Value("${videominer.baseuri}")
    String videominerBaseUri;

    /**
     * Map peertube channel to a videominer channel
     *
     * @param channelId   The identifier of the channel
     * @param maxVideos   The maximum number of videos to return
     * @param maxComments The maximum number of comments for each video
     * @return A videominer channel
     */
    public VMChannel getVMChannel(String channelId, Integer maxVideos, Integer maxComments) throws ChannelNotFoundException {
        String uri = baseUri + "/video-channels/" + channelId;

        try {
            ResponseEntity<Channel> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    Channel.class
            );

            if (response.getBody() == null) throw new ChannelNotFoundException("Channel with id " + channelId + " does not exists");

            List<VMVideo> vmVideos = videoService.getVMVideos(channelId, maxVideos, maxComments);

            Channel channel = response.getBody();

            return transformer.transformChannel(channel, vmVideos);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ChannelNotFoundException("Channel with id " + channelId + " does not exist");
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error while fetching channel with id " + channelId);
        }
    }

    /**
     * create a channel in videominer
     * @param channel videominer channel to be created in videominer
     * @return videominer channel
     */
    public VMChannel sendToVideominer(VMChannel channel) throws VideoMinerCommunicationException {
        String uri = videominerBaseUri + "/channels";

        HttpEntity<VMChannel> request = new HttpEntity<>(channel);

       try {
           ResponseEntity<VMChannel> response = restTemplate.exchange(
                   uri,
                   HttpMethod.POST,
                   request,
                   VMChannel.class);

           return response.getBody();
       } catch (HttpStatusCodeException e) {
           throw new VideoMinerCommunicationException("Failed to send channel to videominer", HttpStatus.BAD_REQUEST);
       } catch (ResourceAccessException e) {
           throw new VideoMinerCommunicationException("Cannot connect with videominer", HttpStatus.SERVICE_UNAVAILABLE);
       }
    }
}
