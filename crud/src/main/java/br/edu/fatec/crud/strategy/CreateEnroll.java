package br.edu.fatec.crud.strategy;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.utils.ParametersUtils;

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