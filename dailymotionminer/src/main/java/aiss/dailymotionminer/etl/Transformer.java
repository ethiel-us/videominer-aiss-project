package aiss.dailymotionminer.etl;

import aiss.dailymotionminer.model.videominer.*;
import aiss.dailymotionminer.model.dailymotion.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Transformer {
    public VMUser transformUser(User user) {
        if ( user == null ) return null;

        String avatarUri = null;
        if (user.getAvatar_720_url() != null && !user.getAvatar_720_url().isEmpty()) {
            avatarUri =  user.getAvatar_720_url();
        }

        return VMUser.of(
                String.valueOf(user.getId()),
                user.getScreenname(),
                user.getUrl(),
                avatarUri
        );
    }

    public VMComment transformComment(Tag t) {
        if (t == null) return null;

        return VMComment.of(
                null,
                t.getText(),
                null);
    }

    public VMCaption transformCaption(Subtitle s) {
        if (s == null) return null;

        return VMCaption.of(
                s.getId(),
                s.getUrl(),
                s.getLanguage()
        );
    }

    public VMVideo transformVideo(Video v, List<VMComment> comments, List<VMCaption> captions) {
        if (v == null) return null;

        VMVideo vmVideo = VMVideo.of(
                String.valueOf(v.getId()),
                v.getTitle(),
                v.getDescription(),
                v.getCreated_time().toString(),
                null
        );

        vmVideo.setComments(comments);
        vmVideo.setCaptions(captions);

        return vmVideo;
    }

    public VMChannel transformChannel(User u, List<VMVideo> videos) {
        if (u == null) return null;

        VMChannel vmChannel = VMChannel.of(
                String.valueOf(u.getId()),
                u.getScreenname(),
                u.getDescription(),
                u.getCreated_Time().toString()
        );

        vmChannel.setVideos(videos);

        return vmChannel;
    }
}

