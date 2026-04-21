package aiss.peertubeminer.service;

import aiss.peertubeminer.model.peertube.Caption;
import aiss.peertubeminer.model.peertube.CaptionSearch;
import aiss.peertubeminer.model.videominer.VMCaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaptionService {

    @Value("${peertubeminer.baseuri}")
    String baseUri;

    @Autowired
    RestTemplate restTemplate;

    /**
     * Map peeertube captions to videominer captions
     * @param videoId The identifier of the video
     * @return A list of videominer model captions
     */
    public List<VMCaption> getVMCaptions(String videoId) {
        String uri = baseUri + "/videos/" + videoId + "/captions";
        List<VMCaption> vmCaptions = new ArrayList<>();
        List<Caption> captions;

        ResponseEntity<CaptionSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,CaptionSearch.class
        );

        if (response.getBody() == null || response.getBody().getData() == null) {
            return new ArrayList<>();
        }
        captions = response.getBody().getData();

        for (Caption c : captions) {
            VMCaption vmCaption = VMCaption.of(
                    c.getLanguage().getId(),
                    c.getFileUrl(),
                    c.getLanguage().getLabel()
            );
            vmCaptions.add(vmCaption);
        }

        return vmCaptions;
    }
}
