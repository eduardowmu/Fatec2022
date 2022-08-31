package br.edu.fatec2022.dto;

import java.time.LocalDate;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Setter
@Getter
public class StudentDto implements Dto {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String mediumName;
	private String lastName;
	private String birthDate;
	private String startDate;
	private String endDate;
	private String enrollNumber;
	private Integer position;
	private String email;

	@Override
	public EntityDomain toEntity() {
		return Student.builder()
				.firstName(this.getFirstName())
				.mediumName(this.getMediumName())
				.lastName(this.getLastName())
				.birthDate(LocalDate.parse(this.getBirthDate()))
				.startDate(LocalDate.parse(this.getStartDate()))
				.endDate(LocalDate.parse(this.getEndDate()))
				.enrollNumber(this.getEnrollNumber() != null ? this.getEnrollNumber() : null)
				.position(this.getPosition())
				.email(this.getEmail())
				.build();
	}
}