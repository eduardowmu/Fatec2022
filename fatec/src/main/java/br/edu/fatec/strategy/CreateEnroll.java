package br.edu.fatec.strategy;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Student;
import br.edu.fatec.utils.ParametersUtils;

public class CreateEnroll implements StrategyPattern {
	@Override
	public EntityDomain process(EntityDomain ed) {
		var student = (Student)ed;
		student.setEnrollNumber(this.setCurseCode(student));
		return student;
	}
	
	private String setCurseCode(Student student) {
		return student.getCourseId().concat(String.valueOf(student.getStartDate().getYear()))
				.concat(this.returnTextPosition(student.getPosition()));
	}
	
	private String returnTextPosition(Integer position) {
		String pos = String.valueOf(position);
		if(pos.length() > 1) {
			return pos;
		}
		return ParametersUtils.ZERO.concat(pos);
	}
}