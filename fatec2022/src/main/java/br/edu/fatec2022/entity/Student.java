package br.edu.fatec2022.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.fatec2022.dto.Dto;
import br.edu.fatec2022.dto.StudentDto;
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
	@Column(nullable=false)
	private LocalDate birthDate;
	@Column(nullable=false)
	private LocalDate startDate;
	@Column(nullable=true)
	private LocalDate endDate;
	private String enrollNumber;
	private Integer position;
	private String email;
	
	@Override
	public Dto toDto() {
		return StudentDto.builder()
				.firstName(this.getFirstName())
				.mediumName(this.getMediumName())
				.lastName(this.getLastName())
				.birthDate(String.format("dd/MM/yyyy", this.getBirthDate()))
				.startDate(String.format("dd/MM/yyyy", this.getStartDate()))
				.endDate(String.format("dd/MM/yyyy", this.getEndDate()))
				.position(this.getPosition())
				.email(this.getEmail())
				.build();
	}
}
