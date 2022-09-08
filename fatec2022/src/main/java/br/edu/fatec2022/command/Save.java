package br.edu.fatec2022.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.services.Facade;
import br.edu.fatec2022.services.IFacade;

public class Save implements Command {
	private final IFacade facade;
	
	@Autowired
	public Save() {
		this.facade = new Facade();
	}

	@Override
	public EntityDomain execute(EntityDomain ed) {
		return this.facade.save(ed);
	}
}