package br.edu.fatec.crud.strategy;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Student;
import br.edu.fatec.utils.ParametersUtils;

public class CreateEmail implements StrategyPattern {
	@Override
	public EntityDomain process(EntityDomain ed) {
		var student = (Student)ed;
		student.setEmail(this.setStudentEmail(student));
		return student;
	}
	
	private String setStudentEmail(Student student) {
		return student.getFirstName().toLowerCase().concat(ParametersUtils.DOT)
				.concat(student.getLastName().toLowerCase())
				.concat(ParametersUtils.EMAIL);
	}
}