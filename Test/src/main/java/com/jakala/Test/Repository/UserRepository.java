package com.jakala.Test.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakala.Test.Model.User;
/**
 * 
 * Repository per la gestione dei dati degli utenti.
 * @author Fabri
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer>
{
	List<User> findByName(String name);
	List<User> findByUsertype(String userType);
	Optional<User> findById(int userId);
}
