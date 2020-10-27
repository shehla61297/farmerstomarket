package com.mastek.farmertomarket.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.farmertomarket.entities.Farmer;


@Repository
public interface FarmerJPADAO extends CrudRepository<Farmer, Integer> {


	@Query("select a from Farmer a where a.farmerEmail=:farmerEmail and a.farmerPassword=:farmerPassword")
	public Farmer findFarmerLogin(@Param("farmerEmail") String email, @Param("farmerPassword") String password);

//	@Query("select user from Farmer user where user.email=:email")
//	public Farmer emailCheck(@Param("email") String email);
}

