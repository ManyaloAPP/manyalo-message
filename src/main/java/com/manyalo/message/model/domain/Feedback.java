package com.manyalo.message.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback_messages")
public class Feedback {

    @Id
    @Column("id")
    private Long feedbackId;

    @Column("message")
    private String message;

    @Column("times_tamp")
    private LocalDateTime timeStamp;

    @Column("user_id")
    private Long userId;

}
