package br.edu.fatec.crud.command;

import br.edu.fatec.crud.model.EntityDomain;

public class Save extends CommandImpl {

	@Override
	public EntityDomain execute(EntityDomain ed) {
		var service = this.getService(ed.getClass().getSimpleName());
		return service.save(ed);
	}
}