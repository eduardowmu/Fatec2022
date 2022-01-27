package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.utils.ParametersUtils;

public class CreateEmail implements Rule {
	@Override
	public Object process(EntityDomain ed) {
		var student = (Student)ed;
		student.setEmail(this.setStudentEmail(student));
		return student;
	}
	
	private String setStudentEmail(Student student) {
		return student.getFirstName() + "." + student.getLastName() + ParametersUtils.EMAIL;
	}
}