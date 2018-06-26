package com.rttCom.rttCom.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
public class OrdineCanale {

	@Id                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column                                                
	private int id;
	
	@Column
	private int id_canale;
	
	@Column(name = "id_ordine_canale")
	private int idOrdineCanale;
	
	@Column
	private int destinatario;

	@OneToMany(mappedBy = "ordineCanale")
	private Set<ProdottoOrdine> prodotti;
	
	@Column
	private String stato;

	@Column(name = "data_ordine")
	private Date dataOrdine;

}
