package aiss.dailymotionminer.service;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.videominer.VMComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Value("${dailymotion.baseuri}")
    String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Transformer transformer;

    /**
     * Map dailymotion comments to videominer comments
     *
     * @param videoId     The identifier of the video
     * @param maxTags The maximum number of comments to return
     * @return A list of videominer comments
     */
    public List<VMComment> getVMComments(String videoId, Integer maxTags) {
        String uri = baseUri + "/video/" + videoId + "?fields=tags";
        List<String> ptComments;

        ResponseEntity<Video> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                Video.class
        );

        if (response.getBody() == null || response.getBody().getTags() == null) {
            return new ArrayList<>();
        }

        ptComments = response.getBody().getTags();

        // For each dailymotion comment, map it to a videominer comment
        return ptComments.stream()
                .map(transformer::transformComment)
                .limit(maxTags)
                .toList();
    }
}
