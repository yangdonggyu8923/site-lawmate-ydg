package com.example.webflux.reply.repository;

import com.example.webflux.reply.domain.ReplyModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReplyRepository extends ReactiveMongoRepository<ReplyModel, String>{
    Flux<ReplyModel> findByLawyerId(String lawyerId);
//    Mono<ReplyModel> findByLawyerId(String id);
}
