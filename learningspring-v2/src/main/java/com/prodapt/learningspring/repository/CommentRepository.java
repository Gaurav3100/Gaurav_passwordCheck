package com.prodapt.learningspring.repository;

import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByPost(Post post);
    
    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId ORDER BY c.timeStamp ASC")
    List<Comment> findCommentsByPostIdOrderByTimestampAsc(@Param("postId") Long postId);

}
