package br.edu.fatec2022.command;

import br.edu.fatec2022.entity.EntityDomain;

public class Save extends AbstractCommand {
	@Override
	public EntityDomain execute(EntityDomain ed) {
		return this.facade.save(ed);
	}
}