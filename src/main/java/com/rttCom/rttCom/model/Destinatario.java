package com.rttCom.rttCom.model;

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
public class Destinatario {

	@Id                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column                                                
	private int id;
	
	@Column                                                
	private int id_destinatario;
	
	@Column
    private String nome;
	
	@Column
    private String cognome;
	
	@Column
    private String indirizzo;

	@Column(name = "cod_fiscale")
    private String codFiscale;
	
	@Column
	private String email;
	
	@Column
	private int telefono;
	
}
