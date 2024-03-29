package br.edu.fatec.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}