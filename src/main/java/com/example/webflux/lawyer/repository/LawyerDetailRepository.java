package com.example.webflux.lawyer.repository;

import com.example.webflux.lawyer.domain.LawyerDetailModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerDetailRepository extends ReactiveMongoRepository<LawyerDetailModel, String>{
}
