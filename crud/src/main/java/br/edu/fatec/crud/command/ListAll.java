package br.edu.fatec.crud.command;

import java.util.List;

import br.edu.fatec.crud.model.EntityDomain;

public class ListAll extends CommandImpl {

	@Override
	public List<EntityDomain> execute(EntityDomain ed) {
		var service = this.getService(ed.getClass().getSimpleName());
		return service.listAll();
	}
}