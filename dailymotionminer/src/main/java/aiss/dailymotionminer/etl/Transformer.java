package aiss.dailymotionminer.etl;

import aiss.dailymotionminer.model.dailymotion.Subtitle;
import aiss.dailymotionminer.model.dailymotion.User;
import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.videominer.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Transformer class responsible for mapping Dailymotion resources into VideoMiner resources.
 * <p>
 * It converts:
 * - Dailymotion User objects into VideoMiner User and Channel objects
 * - Dailymotion Video objects into VideoMiner Video objects
 * - Dailymotion Tag objects into VideoMiner Comment objects
 * - Dailymotion Subtitle objects into VideoMiner Caption objects
 *
 */
@Component
public class Transformer {

    public VMUser transformUser(User user) {
        if (user == null) return null;

        String avatarUri = null;
        if (user.getAvatar_720_url() != null && !user.getAvatar_720_url().isEmpty()) {
            avatarUri = user.getAvatar_720_url();
        }

        return VMUser.of(
                String.valueOf(user.getId()),
                user.getScreenname(),
                user.getUrl(),
                avatarUri
        );
    }

    public VMComment transformComment(String tag) {
        if (tag == null) return null;

        return VMComment.of(
                "",
                tag,
                "");
    }

    public VMCaption transformCaption(Subtitle subtitle) {
        if (subtitle == null) return null;

        return VMCaption.of(
                subtitle.getId(),
                subtitle.getUrl(),
                subtitle.getLanguage()
        );
    }

    public VMVideo transformVideo(Video video, List<VMComment> comments, List<VMCaption> captions) {
        if (video == null) return null;

        VMVideo vmVideo = VMVideo.of(
                String.valueOf(video.getId()),
                video.getTitle(),
                video.getDescription(),
                video.getCreated_time().toString(),
                null
        );

        vmVideo.setComments(comments);
        vmVideo.setCaptions(captions);

        return vmVideo;
    }

    public VMChannel transformChannel(User user, List<VMVideo> videos) {
        if (user == null) return null;

        VMChannel vmChannel = VMChannel.of(
                String.valueOf(user.getId()),
                user.getScreenname(),
                user.getDescription(),
                String.valueOf(user.getCreated_Time())
        );

        vmChannel.setVideos(videos);

        return vmChannel;
    }
}

