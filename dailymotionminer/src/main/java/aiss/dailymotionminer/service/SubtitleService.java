package aiss.dailymotionminer.service;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.Subtitle;
import aiss.dailymotionminer.model.dailymotion.SubtitleSearch;
import aiss.dailymotionminer.model.videominer.VMCaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubtitleService {

    @Value("${dailymotion.baseuri}")
    String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Transformer transformer;

    /**
     * Map dailymotion captions to videominer captions
     *
     * @param videoId The identifier of the video
     * @return A list of videominer model captions
     */

    public List<VMCaption> getVMCaptions(String videoId) {
        String uri = baseUri + "/video/" + videoId + "/subtitles?fields=id,language,url";
        List<Subtitle> captions;

        ResponseEntity<SubtitleSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                SubtitleSearch.class
        );

        if (response.getBody() == null || response.getBody().getList() == null) {
            return new ArrayList<>();
        }

        captions = response.getBody().getList();

        return captions.stream()
                .map(transformer::transformCaption)
                .toList();
    }
}
