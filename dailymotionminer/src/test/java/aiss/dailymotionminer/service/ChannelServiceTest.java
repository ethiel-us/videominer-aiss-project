package aiss.dailymotionminer.service;

import aiss.dailymotionminer.exception.ChannelNotFoundException;
import aiss.dailymotionminer.model.videominer.VMChannel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void getVMChannel() throws ChannelNotFoundException {
        // Use a known Dailymotion user ID, e.g., 'cnn'
        String channelId = "cnn";
        VMChannel channel = channelService.getVMChannel(channelId, 1, 0);
        assertNotNull(channel, "Channel should not be null");
        System.out.println("[DEBUG_LOG] Channel name: " + channel.getName());
    }
}
