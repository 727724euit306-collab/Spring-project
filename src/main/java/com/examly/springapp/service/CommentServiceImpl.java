package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> opt = commentRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> opt = commentRepository.findById(id);
        if (opt.isPresent()) {
            Comment existing = opt.get();
            existing.setContent(comment.getContent());
            existing.setIsInternal(comment.getIsInternal());
            existing.setGrievance(comment.getGrievance());
            existing.setUser(comment.getUser());
            return commentRepository.save(existing);
        }
        return null;
    }
}
