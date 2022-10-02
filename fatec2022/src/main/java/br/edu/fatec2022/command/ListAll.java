package br.edu.fatec2022.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.services.Facade;
import br.edu.fatec2022.services.IFacade;

public class ListAll implements Command {
	private final IFacade facade;
	
	@Autowired
	public ListAll() {
		this.facade = new Facade();
	}

	@Override
	public List<EntityDomain> execute(EntityDomain ed) {
		return this.facade.findAll(ed.getClass().getName());
	}
}