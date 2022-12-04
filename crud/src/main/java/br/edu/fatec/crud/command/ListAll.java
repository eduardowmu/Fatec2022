package br.edu.fatec.crud.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.facade.Facade;
import br.edu.fatec.model.EntityDomain;

public class ListAll implements Command {
	private final Facade facade;
	
	@Autowired
	public ListAll() {
		this.facade = new Facade();
	}

	@Override
	public List<EntityDomain> execute(EntityDomain ed) {
		return this.facade.findAll(ed.getClass().getName());
	}
}
