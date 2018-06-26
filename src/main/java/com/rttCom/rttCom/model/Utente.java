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
public class Utente{

	@Id                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column                                                
	private int id;
	@Column
    private String username;
	@Column
    private String password;
	@Column
    private String nome;
	@Column
    private String cognome;
	
}
