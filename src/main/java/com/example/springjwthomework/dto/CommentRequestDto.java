package com.example.springjwthomework.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Integer postId;
    private String contents;
}
