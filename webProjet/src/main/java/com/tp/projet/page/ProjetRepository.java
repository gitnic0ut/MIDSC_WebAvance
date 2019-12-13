package com.tp.projet.page;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * ProjetRepository
 */
public interface ProjetRepository extends CrudRepository<Projet, Long>{

}