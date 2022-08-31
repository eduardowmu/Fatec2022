package br.edu.fatec2022.dto;

import java.io.Serializable;

import br.edu.fatec2022.entity.EntityDomain;

public interface Dto extends Serializable{
	public EntityDomain toEntity();
}
