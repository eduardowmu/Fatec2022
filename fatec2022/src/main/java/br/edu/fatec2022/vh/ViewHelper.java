package br.edu.fatec2022.vh;

import org.springframework.http.ResponseEntity;

import br.edu.fatec2022.entity.EntityDomain;

public interface ViewHelper {
	EntityDomain getEntity(EntityDomain ed);
	ResponseEntity<?> setResponse(Object obj);
}