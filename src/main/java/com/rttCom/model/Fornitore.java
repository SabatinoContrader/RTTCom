package com.rttCom.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data

@Entity
public class Fornitore {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "fornitore", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProdottoFornitore> listaAcquisto = new ArrayList<ProdottoFornitore>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "fornitore", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<OrdineAcquisto> listaOrdiniAcquisto = new ArrayList<OrdineAcquisto>();

}
