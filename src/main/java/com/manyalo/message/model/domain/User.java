package com.manyalo.message.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column("id")
    private Long userId;

    @Column("user_name")
    private String userName;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("university_id")
    private int universityCode;
    
    @Column("careers_id")
    private int careersCode;
    
    @Column("status")
    private String status;
    
    @Column("type")
    private String type;

}
