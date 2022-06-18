package com.gft.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.minhaloja.entities.Escritor;

@Repository
public interface EscritorRepository extends JpaRepository<Escritor, Long> {

}
