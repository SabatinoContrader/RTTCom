package main.model;

public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private String password;

    public Utente() {
    }

    public Utente(int id, String nome, String cognome, String nomeUtente, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
