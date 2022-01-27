package br.edu.fatec2022.command;


import org.springframework.http.ResponseEntity;

import br.edu.fatec2022.entity.EntityDomain;

public class Delete extends AbstractCommand {
	@Override
	public ResponseEntity<Void> execute(EntityDomain ed) {
		this.facade.delete(ed);
		return ResponseEntity.noContent().build();
	}
}