package com.example.webflux.post.service;

import com.example.webflux.lawyer.domain.LawyerModel;
import com.example.webflux.lawyer.repository.LawyerRepository;
import com.example.webflux.post.domain.PostModel;
import com.example.webflux.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final LawyerRepository lawyerRepository;


    public Mono<PostModel> createPost(String lawyerId, PostModel post) {
        post.setLawyerId(lawyerId);
        return postRepository.save(post);
    }
    public Flux<PostModel> getPostsByLawyerId(String lawyerId) {
        return postRepository.findByLawyerId(lawyerId);
    }

    public Mono<PostModel> updatePost(String id, PostModel post) {
        return postRepository.findById(id)
                .flatMap(i->{
                    i.setTitle(post.getTitle());
                    i.setContent(post.getContent());
                    return postRepository.save(i);
                });
    }

    public Flux<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    public Mono<Void> deletePost(String id) {
        return postRepository.deleteById(id);
    }
}
