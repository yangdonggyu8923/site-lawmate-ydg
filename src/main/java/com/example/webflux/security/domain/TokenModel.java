package com.example.webflux.security.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("tokens")
@ToString
public class TokenModel {
    @Id
    private String id;
    private String refreshToken;
    private String email;
    private Date expiration;

}
