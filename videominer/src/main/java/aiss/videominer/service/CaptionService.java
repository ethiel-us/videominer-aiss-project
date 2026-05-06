package aiss.videominer.service;


import aiss.videominer.model.Caption;
import aiss.videominer.repository.CaptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptionService {

    @Autowired
    private CaptionRepository captionRepository;

    public List<Caption> getAllCaptions() {return captionRepository.findAll();}
    public Caption getCaptionById(String id) { return captionRepository.findById(id).orElse(null);}


}
