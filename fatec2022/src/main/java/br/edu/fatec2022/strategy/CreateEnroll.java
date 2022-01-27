package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;

public class CreateEnroll implements Rule {
	@Override
	public Object process(EntityDomain ed) {
		var student = (Student)ed;
		student.setEnrollNumber(this.setCurseCode(student));
		return student;
	}
	
	private String setCurseCode(Student student) {
		return student.getEnrollNumber() + student.getStartDate().getYear() + student.getPosition();
	}
}