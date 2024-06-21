package com.example.webflux.lawyer.repository;

import com.example.webflux.lawyer.domain.LawyerDetailModel;
import com.example.webflux.lawyer.domain.LawyerModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Repository
public interface LawyerRepository extends ReactiveMongoRepository<LawyerModel, String> {

    Flux<LawyerModel> findByName(String name);
    Mono<LawyerModel> findByUsername(String username);
    Mono<LawyerModel> findByDetail(LawyerDetailModel detail);


}
