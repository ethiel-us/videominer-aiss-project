package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.videominer.VMChannel;
import aiss.peertubeminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peertube")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    /**
     * Get a channel by its ID from peertube API
     * @param id Identifier of the channel to retrieve
     * @param maxVideos Maximum number of videos to retrieve
     * @param maxComments Maximum number of comments to retrieve
     * @return A channel with the videominer model
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VMChannel getChannel(
            @PathVariable String id,
            @RequestParam(defaultValue = "10") Integer maxVideos,
            @RequestParam(defaultValue = "10") Integer maxComments) {
        return channelService.getVMChannel(id, maxVideos, maxComments);
    }

    /**
     * Create a channel in videominer
     * @param id Channel identifier
     * @param maxVideos Maximum number of videos to save
     * @param maxComments Maximum number of comments to save
     * @return The created channel
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public VMChannel create(
            @PathVariable String id,
            @RequestParam(defaultValue = "10") Integer maxVideos,
            @RequestParam(defaultValue = "10") Integer maxComments) {
        VMChannel channel = channelService.getVMChannel(id, maxVideos, maxComments);

        return channelService.sendToVideominer(channel);
    }
}
