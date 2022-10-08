package br.edu.fatec2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec2022.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {}