package com.example.webflux.notification.repository;

import com.example.webflux.notification.domain.NoticeModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NoticeRepository extends ReactiveMongoRepository<NoticeModel, String> {
    Flux<NoticeModel> findByUserId(String userId);
}
