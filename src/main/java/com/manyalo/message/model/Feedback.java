package com.manyalo.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback_messages")
public class Feedback {

    @Id
    @Column("id")
    private Long feedbackId;

    @Column("message")
    private String message;

    @Column("time_stamp")
    private LocalDate timeStamp;

    @Column("status")
    private String status;

    @Column("response")
    private String response;

    @Column("user_id")
    private User user;

}
