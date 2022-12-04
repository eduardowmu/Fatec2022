package br.edu.fatec.crud.strategy;

import java.time.LocalDate;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Message;
import br.edu.fatec.model.Student;
import br.edu.fatec.utils.MessageUtils;
import br.edu.fatec.utils.ParametersUtils;

public class ValidateDate implements StrategyPattern {
	@Override
	public EntityDomain process(EntityDomain ed) {
		var student = (Student)ed;
		var age = LocalDate.now().getYear() - student.getBirthDate().getYear();
		if(age < 18) {
			return Message.builder()
					.value(MessageUtils.HAS_NOT_AGE_ENOUGTH.concat(ParametersUtils.DOUBLE_POINT)  + age)
					.eventDate(LocalDate.now())
					.build();
		}
		return student;
	}
}