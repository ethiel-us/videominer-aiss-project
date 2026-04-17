package aiss.peertubeminer.service;

import aiss.peertubeminer.model.peertube.Video;
import aiss.peertubeminer.model.peertube.VideoSearch;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Video> getVideos(String channel) {
        String uri = "https://peertube.tv/api/v1/video-channels/" + channel + "/videos";

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
