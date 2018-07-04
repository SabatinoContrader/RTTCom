package com.rttCom.dao;

import java.util.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jca.cci.connection.*;

import com.rtt.Constants.StatoOrdineAcquisto;
import com.rtt.Constants.StatoOrdineVendita;
import com.rttCom.model.OrdineAcquisto;
import com.rttCom.model.OrdineVendita;
import com.rttCom.model.Prodotto;

@Repository
@Transactional
public interface OrdineAcquistoRepository extends CrudRepository<OrdineAcquisto, Long> {
	
	
   List<OrdineAcquisto> findByStato(StatoOrdineAcquisto statoOrdine);
	
	OrdineAcquisto save(OrdineAcquisto ordineacquisto);
	
	List<OrdineAcquisto> findAll();
}
