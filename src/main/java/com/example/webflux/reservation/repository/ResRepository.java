package com.example.webflux.reservation.repository;

import com.example.webflux.reservation.domain.ResModel;
import org.apache.logging.log4j.util.Lazy;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface ResRepository extends ReactiveMongoRepository<ResModel, String> {
//    Flux<ResModel> findByDate(LocalDate date);
    Flux<ResModel> findByLawyerIdAndNotifiedFalse(String lawyerId);

//    Mono<ResModel> findByLawyerId(String id);
}
