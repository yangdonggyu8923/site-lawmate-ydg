package com.example.webflux.reply.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "replies")
@Builder
@AllArgsConstructor
@ToString(exclude = "id")
@NoArgsConstructor
public class ReplyModel {
    @Id
    String id;
    String content;
    String lawyerId;
    String questionId;
}
