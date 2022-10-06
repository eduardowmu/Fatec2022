package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.utils.ParametersUtils;

public class CreateEnroll implements Rule {
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