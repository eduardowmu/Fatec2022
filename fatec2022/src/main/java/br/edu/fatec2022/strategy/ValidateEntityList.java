package br.edu.fatec2022.strategy;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.repository.StudentDao;
import br.edu.fatec2022.utils.MessageUtils;
import br.edu.fatec2022.utils.ParametersUtils;

public class ValidateEntityList implements Rule {
	private StudentDao studentDao;
	
	@Autowired
	public ValidateEntityList(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public EntityDomain process(EntityDomain ed) {
		switch(ed.getClass().getName().replace(ParametersUtils.ENTITY_PACKAGE, ParametersUtils.EMPTY).toLowerCase()) {
			case ParametersUtils.STUDENT:
				return !this.studentDao.findAll().isEmpty() ? ed :
					Message.builder()
					.value(MessageUtils.NOT_FOUND_ANY_OBJECT)
					.eventDate(LocalDate.now())
					.build();
		}
		return null;
	}
}