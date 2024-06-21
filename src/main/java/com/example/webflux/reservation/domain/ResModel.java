package com.example.webflux.reservation.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "reservations")
@Builder
@AllArgsConstructor
@ToString(exclude = "id")
@NoArgsConstructor
public class ResModel {
    @Id
    String id;
    String lawyerId;
    String userId;
    String date;
    String startTime;
    String endTime;
    String status;
    Boolean notified;
}
