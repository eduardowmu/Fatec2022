package br.edu.fatec.crud.strategy;

import java.time.LocalDate;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.utils.MessageUtils;

public class ValidateName implements StrategyPattern {
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