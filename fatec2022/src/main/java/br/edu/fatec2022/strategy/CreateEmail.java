package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;

public class CreateEmail implements Rule {
	@Override
	public Object process(EntityDomain ed) {
		var student = (Student)ed;
		
		return null;
	}
	
	private String setStudentEmail(Student student) {
		return student.getFirstName() + "." + student.getLastName() + "@fatec.sp.gov.br";
	}
}