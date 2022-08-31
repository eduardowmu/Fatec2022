package br.edu.fatec2022.entity;

import java.io.Serializable;

import br.edu.fatec2022.dto.Dto;

public abstract class EntityDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	public abstract Dto toDto();
}