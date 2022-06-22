package com.jdbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jdbc.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	//Custom finder method
	public List<User> findByCity(String city);
	public List<User> findByNameAndCity(String name, String city);
	
	//JPQL
	@Query("SELECT u FROM User u")
	public List<User> getAll();
	
	@Query("SELECT u FROM User u WHERE u.name= :n")
	public List<User> getuserByName (@Param("n") String name);
	
	@Query("SELECT u FROM User u WHERE u.name= :n AND u.city= :c")
	public List<User> getuserByNameAndCity (@Param("n") String name, @Param("c") String city);
	
	//Native query
	@Query(value= "SELECT * FROM user", nativeQuery=true)
	public List<User> getUserNative();
}
