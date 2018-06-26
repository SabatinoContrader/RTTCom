package com.rttCom.rttCom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
public class OrdineFornitore {

	@Id                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column                                                
	private int id;
	
	@Column(name = "id_fornitore")
	private int idFornitore;

	@Column(name = "id_ordine_canale")
	private int idOrdineCanale;
	
	@Column(name = "id_ordine_su_fornitore")
	private int idOrdineSuFornitore;
	
	@Column
	private int destinatario;
	
	@Column
	private String stato;

	@Column(name = "data_ordine")
	private Date dataOrdine;
	
}
