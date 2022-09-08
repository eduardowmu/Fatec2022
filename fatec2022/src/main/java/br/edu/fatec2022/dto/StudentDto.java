package br.edu.fatec2022.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
	public Student toEntity() {
		return Student.builder()
				.firstName(this.firstName)
				.mediumName(this.mediumName)
				.lastName(this.lastName)
				.birthDate(this.getDate(this.getBirthDate()))
				.startDate(this.getDate(this.getStartDate()))
				.endDate(this.endDate != null ? this.getDate(this.getEndDate()) : null)
				.enrollNumber(this.getEnrollNumber() != null ? this.getEnrollNumber() : null)
				.position(this.getPosition())
				.email(this.getEmail())
				.build();
	}
	
	private LocalDate getDate(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8));
		return LocalDate.of(year, month, day);
	}
}