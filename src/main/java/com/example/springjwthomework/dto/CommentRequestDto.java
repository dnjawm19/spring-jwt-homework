package com.example.springjwthomework.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private String contents;
}