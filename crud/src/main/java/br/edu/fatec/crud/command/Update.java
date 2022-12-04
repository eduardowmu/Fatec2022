package br.edu.fatec.crud.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.facade.Facade;
import br.edu.fatec.model.EntityDomain;

public class Update implements Command {
	private final Facade facade;
	
	@Autowired
	public Update() {
		this.facade = new Facade();
	}

	@Override
	public EntityDomain execute(EntityDomain ed) {
		return this.facade.update(ed);
	}
}