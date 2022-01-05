package br.edu.fatec2022.command;


import br.edu.fatec2022.entity.EntityDomain;

public interface Command {
	Object execute(EntityDomain ed);
}
