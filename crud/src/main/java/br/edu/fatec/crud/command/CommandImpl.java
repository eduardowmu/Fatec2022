package br.edu.fatec.crud.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.crud.service.Facade;
import br.edu.fatec.crud.service.MessageService;
import br.edu.fatec.crud.service.StudentService;
import br.edu.fatec.crud.utils.ParametersUtils;

public abstract class CommandImpl implements Command {
	@Autowired
	protected StudentService studentService;
	
	@Autowired
	protected MessageService messageService;
	
	protected Facade getService(String entity) {
			switch(entity) {
			case ParametersUtils.STUDENT:
				return this.studentService;
				
			default:
				return this.messageService;
		}
	}	
}