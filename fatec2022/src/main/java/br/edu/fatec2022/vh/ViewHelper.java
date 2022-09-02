package br.edu.fatec2022.vh;

import br.edu.fatec2022.dto.Dto;
import br.edu.fatec2022.entity.EntityDomain;

public interface ViewHelper {
	public EntityDomain requestEntity(Dto body);
	public Dto responseEntity(EntityDomain ed);
}
