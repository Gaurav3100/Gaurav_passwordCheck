package com.prodapt.learningspring.repository;

import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByPost(Post post);
}
