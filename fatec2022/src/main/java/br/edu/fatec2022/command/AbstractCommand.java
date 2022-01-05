package br.edu.fatec2022.command;
import br.edu.fatec2022.command.Command;
import br.edu.fatec2022.services.Facade;
import br.edu.fatec2022.services.IFacade;

public abstract class AbstractCommand implements Command {
	IFacade facade = new Facade();
}