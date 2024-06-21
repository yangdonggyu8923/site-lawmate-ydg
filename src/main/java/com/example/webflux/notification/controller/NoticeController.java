package com.example.webflux.notification.controller;

import com.example.webflux.notification.domain.NoticeModel;
import com.example.webflux.notification.service.NoticeService;
import com.example.webflux.reservation.domain.ResModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/notifications")
public class NoticeController {
    private final NoticeService service;

    @PostMapping("/subscribe")
    public Mono<NoticeModel> createNoticeModel(@RequestBody NoticeModel notification) {
        return service.createNoticeModel(notification);
    }

    @PostMapping("/{id}/respond")
    public Mono<NoticeModel> respondToNoticeModel(@PathVariable("id") String id, @RequestParam("status") String status) {
        return service.updateNoticeModelStatus(id, status);
    }

    @GetMapping(value = "/lawyer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NoticeModel> subscribeToLawyerNoticeModels() {
        return service.getLawyerNoticeModels();
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NoticeModel> subscribeToUserNoticeModels(@PathVariable("userId") String userId) {
        return service.getUserNoticeModels(userId);
    }

    @GetMapping("/lawyer/{lawyerId}")
    public Flux<NoticeModel> getLawyerNotificationsByLawyerId(@PathVariable("lawyerId") String lawyerId) {
        return service.getNotificationsByLawyerId(lawyerId);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteNotification(@PathVariable("id") String id) {
        return service.deleteNotification(id);
    }



}
