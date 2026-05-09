package aiss.dailymotionminer.controller;


import aiss.dailymotionminer.exception.ChannelNotFoundException;
import aiss.dailymotionminer.exception.VideoMinerCommunicationException;
import aiss.dailymotionminer.model.videominer.VMChannel;
import aiss.dailymotionminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailymotion")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    /**
     * Get a channel by its ID from Dailymotion
     * @param id Dailymotion channel ID
     * @param maxVideos Maximum number of videos to retrieve
     * @param maxComments Maximum number of comments to retrieve
     * @return A channel with the videominer model
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VMChannel getChannel(
            @PathVariable String id,
            @RequestParam(defaultValue = "10") Integer maxVideos,
            @RequestParam(defaultValue = "10") Integer maxComments) throws ChannelNotFoundException{
        return channelService.getVMChannel(id, maxVideos, maxComments);
    }

    /**
     * Create a channel in videominer
     * @param id Dailymotion channel ID
     * @param maxVideos Maximum number of videos to save
     * @param maxComments Maximum number of comments to save
     * @return The created channel
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public VMChannel create(
            @PathVariable String id,
            @RequestParam(defaultValue = "10") Integer maxVideos,
            @RequestParam(defaultValue = "10") Integer maxComments) throws ChannelNotFoundException, VideoMinerCommunicationException {
        VMChannel channel = channelService.getVMChannel(id, maxVideos, maxComments);

        return channelService.sendToVideominer(channel);
    }
}
