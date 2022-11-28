package br.edu.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}