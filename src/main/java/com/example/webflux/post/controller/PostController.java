package com.example.webflux.post.controller;

import com.example.webflux.post.domain.PostModel;
import com.example.webflux.post.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/posts")
public class PostController {
    private final PostServiceImpl service;
    

    @PostMapping("/add/{lawyerId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PostModel> createPost(@PathVariable("lawyerId") String lawyerId, @RequestBody PostModel post) {
        return service.createPost(lawyerId, post);
    }
    @GetMapping("/myPost/{lawyerId}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PostModel> getPostsByLawyerId(@PathVariable("lawyerId") String lawyerId) {
        return service.getPostsByLawyerId(lawyerId);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PostModel> updatePost(@PathVariable("id") String id, @RequestBody PostModel post) {
        return service.updatePost(id, post);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PostModel> getAllPosts() {
        return service.getAllPosts();
    }



    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePost(@PathVariable("id") String id) {
        return service.deletePost(id);
    }

}
