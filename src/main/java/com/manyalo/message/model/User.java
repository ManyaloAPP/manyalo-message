package com.manyalo.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
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

    @Column("university_code")
    private Long universityCode;

}
