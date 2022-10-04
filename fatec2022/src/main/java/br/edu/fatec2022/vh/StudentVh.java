package br.edu.fatec2022.vh;

import java.time.LocalDate;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.utils.ParametersUtils;
import br.edu.fatec2022.vo.EntityVo;

public class StudentVh implements EntityVh {
	@Override
	public Student getEntityRequest(EntityVo e) {
		return Student.builder()
				.id(e.getId() != null ? e.getId() : null)
				.firstName(e.getFirstName() != null ? e.getFirstName() : ParametersUtils.EMPTY)
				.mediumName(e.getMediumName() != null ? e.getMediumName() : ParametersUtils.EMPTY)
				.lastName(e.getLastName() != null ? e.getLastName() : ParametersUtils.EMPTY)
				.birthDate(e.getBirthDate() != null && !e.getBirthDate().equals(ParametersUtils.EMPTY) ? this.getDate(e.getBirthDate()) : null)
				.startDate(e.getStartDate() != null && !e.getStartDate().equals(ParametersUtils.EMPTY) ? this.getDate(e.getStartDate()) : null)
				.endDate(e.getEndDate() != null && !e.getEndDate().equals(ParametersUtils.EMPTY) ? this.getDate(e.getEndDate()) : null)
				.enrollNumber(e.getEnrollNumber() != null ? e.getEnrollNumber() : ParametersUtils.EMPTY)
				.position(e.getPosition() != null ? e.getPosition() : null)
				.email(e.getEmail() != null ? e.getEmail() : ParametersUtils.EMPTY)
				.build();
	}

	@Override
	public EntityVo getEntityResponse(EntityDomain ed) {
		if(ed instanceof Student) {
			Student student = (Student)ed;
			return EntityVo.builder()
					.id(student.getId())
					.firstName(student.getFirstName())
					.mediumName(student.getMediumName())
					.lastName(student.getLastName())
					.birthDate(String.valueOf(student.getBirthDate()))
					.startDate(String.valueOf(student.getStartDate()))
					.endDate(student.getEndDate() != null ? String.valueOf(student.getEndDate()) : ParametersUtils.EMPTY)
					.enrollNumber(student.getEnrollNumber())
					.position(student.getPosition())
					.email(student.getEmail())
					.build();
		} else {
			Message msg = (Message)ed;
			return EntityVo.builder().msg(msg.getValue()).build();
		}
	}

	private LocalDate getDate(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8));
		return LocalDate.of(year, month, day);
	}
}