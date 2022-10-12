package com.example.springjwthomework.controller;

import com.example.springjwthomework.domain.Comment;
import com.example.springjwthomework.domain.Post;
import com.example.springjwthomework.dto.MemberRequestDto;
import com.example.springjwthomework.dto.MemberResponseDto;
import com.example.springjwthomework.dto.TokenRequestDto;
import com.example.springjwthomework.dto.TokenDto;
import com.example.springjwthomework.repository.CommentRepository;
import com.example.springjwthomework.repository.PostRepository;
import com.example.springjwthomework.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final AuthService authService;

    @PostMapping("/member/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/member/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

    @GetMapping("/post")    //게시글 조회
    public List<Post> getPost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/comment")    //게시글 조회
    public List<Comment> getComment() {
        return commentRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/post/{id}")   //게시글 상세 조회
    public Optional<Post> getPostId(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @GetMapping("/comment/{id}")    //댓글 목록 조회
    public Optional<Comment> getCommentId(@PathVariable Long id) {
        return commentRepository.findById(id);
    }
}