package com.prodapt.learningspring.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    private String content;
    
    private LocalDateTime timeStamp;
    
    public LocalDateTime getTimeStamp() {
    	return timeStamp;
    }
    
    public void setTimeStamp(LocalDateTime timeStamp) {
    	this.timeStamp = timeStamp;
    }

}
