package aiss.peertubeminer.etl;

import aiss.peertubeminer.model.peertube.*;
import aiss.peertubeminer.model.videominer.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Transformer class responsible for mapping Peertube objects into VideoMiner objects.
 *
 * It converts:
 * - Peertube Account objects into VideoMiner User objects
 * - Peertube Video objects into VideoMiner Video objects
 * - Peertube Channel objects into VideoMiner Channel objects
 * - Peertube Comment objects into VideoMiner Comment objects
 * - Peertube Caption objects into VideoMiner Caption objects
 *
 */
@Component
public class Transformer {

    public VMUser transformUser(User user) {
        if ( user == null ) return null;

        String avatarUri = null;
        if (user.getAvatars() != null && !user.getAvatars().isEmpty()) {
            avatarUri =  user.getAvatars().getFirst().getFileUrl();
        }

        return VMUser.of(
                String.valueOf(user.getId()),
                user.getDisplayName(),
                user.getUrl(),
                avatarUri
        );
    }

    public VMComment transformComment(Comment c) {
        if (c == null) return null;

        return VMComment.of(
                String.valueOf(c.getId()),
                c.getText(),
                c.getCreatedAt()
        );
    }

    public VMCaption transformCaption(Caption c) {
        if (c == null) return null;

        return VMCaption.of(
                c.getLanguage().getId(),
                c.getFileUrl(),
                c.getLanguage().getLabel()
        );
    }

    public VMVideo transformVideo(Video v, List<VMComment> comments, List<VMCaption> captions) {
        if (v == null) return null;

        VMUser user = transformUser(v.getUser());

        VMVideo vmVideo = VMVideo.of(
                String.valueOf(v.getId()),
                v.getName(),
                v.getDescription(),
                v.getPublishedAt(),
                user
        );

        vmVideo.setComments(comments);
        vmVideo.setCaptions(captions);

        return vmVideo;
    }

    public VMChannel transformChannel(Channel c, List<VMVideo> videos) {
        if (c == null) return null;

        VMChannel vmChannel = VMChannel.of(
                String.valueOf(c.getId()),
                c.getDisplayName(),
                c.getDescription(),
                c.getCreatedAt()
        );

        vmChannel.setVideos(videos);

        return vmChannel;
    }
}
