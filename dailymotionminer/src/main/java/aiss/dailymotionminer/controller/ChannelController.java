package aiss.dailymotionminer.controller;


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

    @GetMapping("/{id}")
    public VMChannel getChannel(
            @PathVariable String id,
            @RequestParam(defaultValue = "10") Integer maxVideos,
            @RequestParam(defaultValue = "10") Integer maxComments) {
        return channelService.getVMChannel(id, maxVideos, maxComments);
    }

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
