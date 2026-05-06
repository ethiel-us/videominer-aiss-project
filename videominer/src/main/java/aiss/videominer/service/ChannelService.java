package aiss.videominer.service;


import aiss.videominer.model.Channel;
import aiss.videominer.model.Video;
import aiss.videominer.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;


    public List<Channel> getAllChannels() { return channelRepository.findAll();}
    public Channel getChannelById(String id) { return channelRepository.findById(id).orElse(null);}

    public Channel createChannel(Channel channel) { return channelRepository.save(channel);}

    // public Channel updateChannel(Channel channel) { return channelRepository.save(channel);}

    // public void deleteChannel(String id) { channelRepository.deleteById(id);}
}
