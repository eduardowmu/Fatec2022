package br.edu.fatec.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.edu.fatec.facade.Facade;
import br.edu.fatec.model.EntityDomain;

public class Delete implements Command {
	private final Facade facade;
	
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