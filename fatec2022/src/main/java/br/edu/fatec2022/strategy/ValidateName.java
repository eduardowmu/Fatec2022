package br.edu.fatec2022.strategy;

import java.time.LocalDate;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.utils.MessageUtils;

public class ValidateName implements Rule {
	@Override
	public EntityDomain process(EntityDomain ed) {
		var student = (Student)ed;
		if(student.getFirstName().isBlank()) {
			return Message.builder()
					.value(MessageUtils.FIRST_NAME_NOT_VALID)
					.eventDate(LocalDate.now())
					.build();
		}
		if(student.getLastName().isBlank()) {
			return Message.builder()
					.value(MessageUtils.LAST_NAME_NOT_VALID)
					.eventDate(LocalDate.now())
					.build();
		}
		return student;
	}
}