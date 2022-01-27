package br.edu.fatec2022.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity(name="students")
public class Student extends EntityDomain {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String mediumName;
	private String lastName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable=false)
	private LocalDate birthDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable=false)
	private LocalDate startDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable=true)
	private LocalDate endDate;
	private String enrollNumber;
	private Integer position;
	private String email;
}
