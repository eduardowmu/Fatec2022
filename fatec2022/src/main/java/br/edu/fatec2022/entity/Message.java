package br.edu.fatec2022.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Message extends EntityDomain {
	private static final long serialVersionUID = 1L;
	private String value;
	private LocalDate eventDate;
}
