package com.example.webflux.lawyer.domain;

import com.example.webflux.post.domain.PostModel;
import com.example.webflux.reply.domain.ReplyModel;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LawyerDto {
    private String id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String birth;
    private String lawyerNo;
    private String account;
    private Boolean auth;

    private List<PostModel> posts;
    private List<ReplyModel> replies;
    private LawyerDetailModel detail;
}
