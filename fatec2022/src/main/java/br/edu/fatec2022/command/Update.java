package br.edu.fatec2022.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.services.Facade;
import br.edu.fatec2022.services.IFacade;

public class Update implements Command {
	private final IFacade facade;
	
	@Autowired
	public Update() {
		this.facade = new Facade();
	}

	@Override
	public EntityDomain execute(EntityDomain ed) {
		return this.facade.update(ed);
	}
}