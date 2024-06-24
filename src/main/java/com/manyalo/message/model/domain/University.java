package com.manyalo.message.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university")
public class University {

    @Id
    @Column("id")
    private Long universityCode;

    @Column("name")
    private String name;

    @Column("address")
    private String address;
}
