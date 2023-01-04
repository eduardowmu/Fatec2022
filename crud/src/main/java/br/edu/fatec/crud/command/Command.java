package br.edu.fatec.crud.command;

import br.edu.fatec.crud.model.EntityDomain;

public interface Command {
	public abstract Object execute(EntityDomain ed);
}
