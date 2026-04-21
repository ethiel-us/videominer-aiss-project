package aiss.peertubeminer.service;

import aiss.peertubeminer.model.peertube.Comment;
import aiss.peertubeminer.model.peertube.CommentSearch;
import aiss.peertubeminer.model.videominer.VMComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Value("${peertubeminer.baseuri}")
    String baseUri;

    @Autowired
    RestTemplate restTemplate;

    /**
     * Map peeertube comments to videominer comments
     *
     * @param videoId     The identifier of the video
     * @param maxComments The maximum number of comments to return
     * @return A list of videominer comments
     */
    public List<VMComment> getVMComments(String videoId, Integer maxComments) {
        String uri = baseUri + "/videos/" + videoId + "/comment-threads?count=" + String.valueOf(maxComments);
        List<VMComment> vmComments = new ArrayList<>();
        List<Comment> ptComments;

        ResponseEntity<CommentSearch> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                CommentSearch.class
        );

        if (response.getBody() == null || response.getBody().getData() == null) {
            return new ArrayList<>();
        }

        ptComments = response.getBody().getData();

        for (Comment c : ptComments) {
            VMComment vmComment = VMComment.of(
                    c.getId().toString(),
                    c.getText(),
                    c.getCreatedAt()
            );
            vmComments.add(vmComment);
        }

        return vmComments;
    }
}
