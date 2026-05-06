package aiss.videominer.service;


import aiss.videominer.model.Comment;
import aiss.videominer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElse(null);
    }


    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }


}
