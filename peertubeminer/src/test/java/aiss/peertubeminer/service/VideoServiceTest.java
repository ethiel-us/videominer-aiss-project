package aiss.peertubeminer.service;

import aiss.peertubeminer.model.peertube.Video;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    @Order(1)
    @DisplayName( "GET - Get videos")
    void getPTVideos() {
        List<Video> videos = videoService.getPTVideos("transport_evolved_take_2");

        assertNotNull(videos, "Videos should not be null");
        assertFalse(videos.isEmpty(), "Videos should not be empty");
        System.out.println(videos.getFirst());
    }
}