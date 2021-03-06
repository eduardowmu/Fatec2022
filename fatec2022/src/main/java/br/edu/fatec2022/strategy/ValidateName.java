package br.edu.fatec2022.strategy;

import java.time.LocalDate;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.entity.Student;

public class ValidateName implements Rule {
	@Override
	public Object process(EntityDomain ed) {
		var student = (Student)ed;
		if(student.getFirstName().isBlank()) {
			return Message.builder().value("First name not valid").eventDate(LocalDate.now());
		}
		if(student.getMediumName().isBlank()) {
			return Message.builder().value("Medium name not valid").eventDate(LocalDate.now());
		}
		if(student.getLastName().isBlank()) {
			return Message.builder().value("Last name not valid").eventDate(LocalDate.now());
		}
		return student;
	}
}