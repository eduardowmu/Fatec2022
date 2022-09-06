package br.edu.fatec2022.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	public Student toEntity() {
		return Student.builder()
				.firstName(this.firstName)
				.mediumName(this.mediumName)
				.lastName(this.lastName)
				.birthDate(this.getDate(this.birthDate))
				.startDate(this.getDate(this.startDate))
				.endDate(this.getDate(this.endDate))
				.enrollNumber(this.getEnrollNumber() != null ? this.getEnrollNumber() : null)
				.position(this.getPosition())
				.email(this.getEmail())
				.build();
	}
	
	private LocalDateTime getDate(String date) {
		return LocalDateTime.parse(date);
	}
}