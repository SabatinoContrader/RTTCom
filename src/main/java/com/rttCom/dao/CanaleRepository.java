package com.rttCom.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.model.Canale;



@Repository
@Transactional
public interface CanaleRepository extends CrudRepository<Canale, Long> {

	Canale findById(int id);
}
