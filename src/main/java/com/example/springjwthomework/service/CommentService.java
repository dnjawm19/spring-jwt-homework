package com.example.springjwthomework.service;

import com.example.springjwthomework.domain.Comment;
import com.example.springjwthomework.dto.CommentRequestDto;
import com.example.springjwthomework.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }
}