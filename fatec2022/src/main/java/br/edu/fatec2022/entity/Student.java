package br.edu.fatec2022.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.edu.fatec2022.dto.StudentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
	private LocalDate birthDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private String enrollNumber;
	private Integer position;
	private String email;
	
	@Override
	public StudentDto toDto() {
		return StudentDto.builder()
				.firstName(this.getFirstName())
				.mediumName(this.getMediumName())
				.lastName(this.getLastName())
				.birthDate(String.valueOf(this.getBirthDate()))
				.startDate(String.valueOf(this.getStartDate()))
				.endDate(String.valueOf(this.getEndDate() != null ? this.getEndDate() : null))
				.position(this.getPosition())
				.email(this.getEmail())
				.build();
	}
}
