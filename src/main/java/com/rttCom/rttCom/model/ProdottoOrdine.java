package com.rttCom.rttCom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
public class ProdottoOrdine {

	@Id                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column                                                
	private int id;

	@Column
	private int id_prodotto;
	
	@Column
	private int quantita;
	
	@Column
	private double prezzo;	

	@ManyToOne
    @JoinColumn(name="idOrdineCanale")
	private OrdineCanale ordineCanale;
}
