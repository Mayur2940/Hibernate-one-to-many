package com.jsp.one_to_many_assingment.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

	@Id
	private int mobileId;
	private String mobileBrand;
	private double mobilePrice;
	private String mobileModel;
	
	@OneToMany
	List<Sim> sim;
}
