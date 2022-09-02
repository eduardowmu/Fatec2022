package br.edu.fatec2022.entity;

import java.io.Serializable;

import br.edu.fatec2022.dto.Dto;

public interface EntityDomain extends Serializable {
	static final long serialVersionUID = 1L;
	public abstract Dto toDto();
}