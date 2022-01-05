package br.edu.fatec2022.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Student extends EntityDomain {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String mediumName;
	private String lastName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String enrollNumber;
	private String email;
}
