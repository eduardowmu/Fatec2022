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
		if(student.getFirstName().isBlank() || this.hasEspecialCharacter(student.getFirstName())) {
			return Message.builder()
					.value(MessageUtils.FIRST_NAME_NOT_VALID)
					.eventDate(LocalDate.now())
					.build();
		}
		if(student.getLastName().isBlank() || this.hasEspecialCharacter(student.getLastName())) {
			return Message.builder()
					.value(MessageUtils.LAST_NAME_NOT_VALID)
					.eventDate(LocalDate.now())
					.build();
		}
		return student;
	}
	
	private Boolean hasEspecialCharacter(String name) {
		for(Character c : name.toCharArray()) {
			if(!c.isLetter(c)) {
				return true;
			}
		}
		return false;
	}
}