package aiss.peertubeminer.service;

import aiss.peertubeminer.exception.ChannelNotFoundException;
import aiss.peertubeminer.model.videominer.VMChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;


    @Test
    @Order(1)
    @DisplayName( "GET - Get Channel")
    void getVMChannel() throws ChannelNotFoundException {
        VMChannel channel = channelService.getVMChannel("tv", 10, 10);

        assertNotNull(channel, "Channel should not be null");
        assertNotNull(channel.getVideos(), "Videos should not be null");
        assertNotNull(channel.getVideos().getFirst().getComments(), "Comments should not be null");
        assertNotNull(channel.getVideos().getFirst().getCaptions(), "Captions should not be null");

        System.out.println(channel.getName());
    }
}