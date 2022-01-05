package br.edu.fatec2022.command;

import java.util.List;

import br.edu.fatec2022.entity.EntityDomain;

public class ListAll extends AbstractCommand {
	@Override
	public List<EntityDomain> execute(EntityDomain ed) {
		return this.facade.findAll();
	}
}