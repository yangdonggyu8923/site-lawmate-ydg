package com.example.webflux.reservation.service;

import com.example.webflux.reservation.domain.ResModel;
import com.example.webflux.reservation.repository.ResRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class ResServiceImpl implements ResService {
    private final ResRepository resRepository;
//    public Flux<ResModel> getReservationsByDate(LocalDate date) {
//        return resRepository.findByDate(date);
//    }
    public Mono<ResModel> createReservation(ResModel resModel) {
        return resRepository.save(resModel);
    }
    public Mono<ResModel> updateReservation(String id, ResModel res) {
        return resRepository.findById(id)
                .flatMap(reservation -> {
                    reservation.setStatus(res
                            .getStatus());
                    return resRepository.save(reservation);
                });
    }






    public Flux<ResModel> getAllReservations() {
        return resRepository.findAll();
    }

//    public Mono<ResModel> getReservationByLawyerId(String id) {
//        return resRepository.findByLawyerId(id);
//    }


    public Mono<Void> deleteReservation(String id) {
        return resRepository.deleteById(id);
    }
}
