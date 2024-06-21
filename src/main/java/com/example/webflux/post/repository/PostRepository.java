package com.example.webflux.post.repository;

import com.example.webflux.post.domain.PostModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PostRepository extends ReactiveMongoRepository<PostModel, String> {
    Flux<PostModel> findByLawyerId(String lawyerId);
}
