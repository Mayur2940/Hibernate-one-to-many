package com.jsp.one_to_many_assingment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sim {
	
	@Id
	private int simId;
	private String simName;
	private long simNumber;
}
