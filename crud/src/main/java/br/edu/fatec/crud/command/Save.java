package br.edu.fatec.crud.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.facade.Facade;
import br.edu.fatec.model.EntityDomain;

public class Save implements Command {
	private final Facade facade;
	
	@Autowired
	public Save() {
		this.facade = new Facade();
	}

	@Override
	public EntityDomain execute(EntityDomain ed) {
		return this.facade.save(ed);
	}
}