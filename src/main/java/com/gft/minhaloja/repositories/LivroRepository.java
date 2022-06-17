package com.gft.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.minhaloja.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
