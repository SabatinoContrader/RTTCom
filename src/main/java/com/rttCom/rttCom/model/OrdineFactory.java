package com.rttCom.rttCom.model;

import java.util.LinkedList;
import java.util.List;

public class OrdineFactory {

	
	private static OrdineFactory ourInstance = new OrdineFactory();

    public static OrdineFactory getInstance() {
        return ourInstance;
    }

    private OrdineFactory() {
    }

    /*
    public List<ProdottoFornitoreOrdine> getOrdini(){
        List<ProdottoFornitoreOrdine> ordini = new LinkedList<ProdottoFornitoreOrdine>();
        ordini.add(new ProdottoFornitoreOrdine(1,30,150));
        ordini.add(new ProdottoFornitoreOrdine(2, 3, 200));
        
        return ordini;
    }*/

	
}
