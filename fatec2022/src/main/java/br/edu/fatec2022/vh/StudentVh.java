package br.edu.fatec2022.vh;

import java.time.LocalDate;

import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.vo.EntityVo;

public class StudentVh implements EntityVh {
	@Override
	public Student getEntityRequest(EntityVo e) {
		return Student.builder()
				.id(e.getId() != null ? e.getId() : null)
				.firstName(e.getFirstName() != null ? e.getFirstName() : "")
				.mediumName(e.getMediumName() != null ? e.getMediumName() : "")
				.lastName(e.getLastName() != null ? e.getLastName() : "")
				.birthDate(e.getBirthDate() != null && !e.getBirthDate().equals("") ? this.getDate(e.getBirthDate()) : null)
				.startDate(e.getStartDate() != null && !e.getStartDate().equals("") ? this.getDate(e.getStartDate()) : null)
				.endDate(e.getEndDate() != null && !e.getEndDate().equals("") ? this.getDate(e.getEndDate()) : null)
				.enrollNumber(e.getEnrollNumber() != null ? e.getEnrollNumber() : "")
				.position(e.getPosition() != null ? e.getPosition() : null)
				.email(e.getEmail() != null ? e.getEmail() : "")
				.build();
	}

	@Override
	public EntityVo getEntityResponse(Object obj) {
		Student student = (Student)obj;
		return EntityVo.builder()
				.id(student.getId())
				.firstName(student.getFirstName())
				.mediumName(student.getMediumName())
				.lastName(student.getLastName())
				.birthDate(String.valueOf(student.getBirthDate()))
				.startDate(String.valueOf(student.getStartDate()))
				.endDate(student.getEndDate() != null ? String.valueOf(student.getEndDate()) : "")
				.enrollNumber(student.getEnrollNumber())
				.position(student.getPosition())
				.email(student.getEmail())
				.build();
	}

	private LocalDate getDate(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8));
		return LocalDate.of(year, month, day);
	}
}