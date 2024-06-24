package com.manyalo.message.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "careers")
public class Career {
	@Column("id")
	private Long careerId;
	@Column("name")
	private String careerName;
}
