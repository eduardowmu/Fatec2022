package br.edu.fatec.command;

import br.edu.fatec.model.EntityDomain;

public interface Command {
	Object execute(EntityDomain ed);
}
