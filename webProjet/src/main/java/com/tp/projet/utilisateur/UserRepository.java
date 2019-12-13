package com.tp.projet.utilisateur;

import java.util.List;
import java.util.Optional;

import com.tp.projet.page.Projet;

import org.springframework.data.repository.CrudRepository;

/**
 * userRepository
 */
public interface UserRepository extends CrudRepository<Users, Long> {

	Optional<Users> findByUserName(String userName);

	List<Users> findAllByOrderByUserName();

	Optional<Users> findById(String username);

	Users findIdByUserName(String userName);

}