package br.edu.fatec2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec2022.entity.Message;

public interface MessageDao extends JpaRepository<Message, Long> {}