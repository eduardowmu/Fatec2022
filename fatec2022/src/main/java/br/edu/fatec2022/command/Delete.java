package br.edu.fatec2022.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.services.Facade;
import br.edu.fatec2022.services.IFacade;

public class Delete implements Command {
	private final IFacade facade;
	
	@Autowired
	public Delete() {
		this.facade = new Facade();
	}
	
	@Override
	public ResponseEntity<Void> execute(EntityDomain ed) {
		this.facade.delete(ed);
		return ResponseEntity.noContent().build();
	}
}