package com.example.webflux.reservation.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResDto {
    private String id;
    private String lawyerId;
    private String userId;
    private String date;
    private String startTime;
    private String endTime;
    private String status;
    private Boolean notified;
}
