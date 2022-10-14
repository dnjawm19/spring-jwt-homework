package com.example.springjwthomework.domain;

import com.example.springjwthomework.dto.CommentRequestDto;
import com.example.springjwthomework.dto.PostRequestDto;
import com.example.springjwthomework.entity.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    @Column(nullable = false)
    private Integer postId;

    @Column(nullable = false)
    private String contents;

    public Comment(CommentRequestDto requestDto, Post post) {
        this.post = post;
        this.contents = requestDto.getContents();
    }

    public void update(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.contents = requestDto.getContents();
    }
}