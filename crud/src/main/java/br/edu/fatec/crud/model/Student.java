package br.edu.fatec.crud.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student extends EntityDomain {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String mediumName;
	private String lastName;
	private LocalDate birthDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private String enrollNumber;
	private String courseId;
	private Integer position;
	private String email;	
}
