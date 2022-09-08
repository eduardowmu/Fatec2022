package br.edu.fatec2022.strategy;

import java.time.LocalDate;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.entity.Student;

public class ValidateDates implements Rule {
	@Override
	public EntityDomain process(EntityDomain ed) {
		var student = (Student)ed;
		var age = student.getStartDate().getYear() - student.getBirthDate().getYear();
		if(age < 18) {
			return Message.builder()
					.value("Student does not have enougth age: "  + age)
					.eventDate(LocalDate.now())
					.build();
		}
		return student;
	}

}
