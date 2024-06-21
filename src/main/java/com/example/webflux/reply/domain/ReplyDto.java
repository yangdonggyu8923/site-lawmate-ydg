package com.example.webflux.reply.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReplyDto {
    private Long id;
    private String content;
    private String lawyerId;
    private String questionId;
}
