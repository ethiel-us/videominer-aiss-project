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
        if (user.getAvatar_url() != null && !user.getAvatar_url().isEmpty()) {
            avatarUri =  user.getAvatar_url();
        }

        return VMUser.of(
                String.valueOf(user.getId()),
                user.getScreenname(),
                user.getUrl(),
                avatarUri
        );
    }

    public VMComment transformComment(Tags t) {
        if (t == null) return null;

        return null;
    }

    public VMCaption transformCaption(Subtitle s) {
        if (s == null) return null;

        return VMCaption.of(
                s.getId(),
                s.getUrl(),
                s.getLanguage()
        );
    }

    public VMVideo transformVideo(Video v, List<VMComment> comments, List<VMCaption> captions, VMUser user) {
        if (v == null) return null;

        VMVideo vmVideo = VMVideo.of(
                String.valueOf(v.getId()),
                v.getTitle(),
                v.getDescription(),
                v.getRelease_time().toString(),
                user
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
                u.TiempoCreado(u.getCreated_Time()).toString()
        );

        vmChannel.setVideos(videos);

        return vmChannel;
    }
}

