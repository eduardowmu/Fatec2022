package br.edu.fatec.crud.vh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.utils.MessageUtils;
import br.edu.fatec.crud.utils.ParametersUtils;
import br.edu.fatec.crud.vo.EntityVo;

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
				.courseId(e.getCourseId() != null ? e.getCourseId() : ParametersUtils.EMPTY)
				.position(e.getPosition() != null ? e.getPosition() : null)
				.build();
	}

	@Override
	public EntityVo getEntityResponse(EntityDomain ed) {
		if(ed instanceof Student) {
			Student student = (Student)ed;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return EntityVo.builder()
					.id(student.getId())
					.firstName(student.getFirstName() != null ? student.getFirstName() : ParametersUtils.EMPTY)
					.mediumName(student.getMediumName() != null ? student.getMediumName() : ParametersUtils.EMPTY)
					.lastName(student.getLastName() != null ? student.getLastName() : ParametersUtils.EMPTY)
					.birthDate(student.getBirthDate() != null ? student.getBirthDate().format(formatter) : ParametersUtils.EMPTY)
					.startDate(student.getStartDate() != null ? student.getStartDate().format(formatter) : ParametersUtils.EMPTY)
					.endDate(student.getEndDate() != null ? student.getEndDate().format(formatter) : ParametersUtils.EMPTY)
					.courseId(student.getCourseId() != null ? student.getCourseId() : ParametersUtils.EMPTY)
					.enrollNumber(student.getEnrollNumber() != null ? student.getEnrollNumber() : ParametersUtils.EMPTY)
					.position(student.getPosition())
					.email(student.getEmail() != null ? student.getEmail() : ParametersUtils.EMPTY)
					.msg(Message.builder().value(MessageUtils.SUCCESS).build().getValue())
					.build();
		} else {
			Message msg = (Message)ed;
			return EntityVo.builder().msg(msg.getValue()).build();
		}
	}

	private LocalDate getDate(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8,10));
		return LocalDate.of(year, month, day);
	}
}