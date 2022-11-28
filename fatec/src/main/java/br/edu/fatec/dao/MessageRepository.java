package br.edu.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {}
