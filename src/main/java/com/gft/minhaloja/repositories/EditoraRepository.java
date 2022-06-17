package com.gft.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.minhaloja.entities.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

}
