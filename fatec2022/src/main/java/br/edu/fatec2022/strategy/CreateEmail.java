package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.utils.ParametersUtils;

public class CreateEmail implements Rule {
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