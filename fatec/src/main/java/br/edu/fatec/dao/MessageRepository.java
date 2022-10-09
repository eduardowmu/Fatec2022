package br.edu.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
