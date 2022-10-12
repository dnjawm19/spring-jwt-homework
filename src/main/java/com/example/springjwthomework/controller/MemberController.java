package com.example.springjwthomework.controller;

import com.example.springjwthomework.domain.Comment;
import com.example.springjwthomework.domain.Post;
import com.example.springjwthomework.dto.CommentRequestDto;
import com.example.springjwthomework.dto.MemberResponseDto;
import com.example.springjwthomework.dto.PostRequestDto;
import com.example.springjwthomework.repository.CommentRepository;
import com.example.springjwthomework.repository.PostRepository;
import com.example.springjwthomework.service.CommentService;
import com.example.springjwthomework.service.MemberService;
import com.example.springjwthomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class MemberController {
    private final PostRepository postRepository;
    private final PostService postService;

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyInfo());
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String nickname) {
        return ResponseEntity.ok(memberService.getMemberInfo(nickname));
    }

    @PostMapping("/post")   //게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @PostMapping("/comment")    //댓글 생성
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }
//
    @PutMapping("/post/{id}")   //게시글 수정
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }
//
    @PutMapping("/comment/{id}")    //댓글 수정
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }
//
    @DeleteMapping("/post/{id}")    //게시글 삭제
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
//
    @DeleteMapping("/comment/{id}") //댓글 삭제
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}