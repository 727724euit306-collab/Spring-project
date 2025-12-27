package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Comment;

public interface CommentService {

    Comment addComment(Comment comment);

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    Comment updateComment(Long id, Comment comment);
}
