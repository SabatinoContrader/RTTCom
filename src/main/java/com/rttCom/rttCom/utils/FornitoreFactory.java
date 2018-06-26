package com.rttCom.rttCom.utils;

import java.util.LinkedList;
import java.util.List;

import com.rttCom.rttCom.model.Fornitore;

public class FornitoreFactory {
    private static FornitoreFactory ourInstance = new FornitoreFactory();

    public static FornitoreFactory getInstance() {
        return ourInstance;
    }

    private FornitoreFactory() {
    }

    public List<Fornitore> getFornitori(){
        List<Fornitore> fornitori = new LinkedList<Fornitore>();
        fornitori.add(new LeroyMerlin());
        fornitori.add(new Brico());
        fornitori.add(new Inditex());
        return fornitori;
    }


}
