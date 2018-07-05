
export class Utente {
  id: number;
  username: string;
  password: string;
  nome: string;
  cognome: string;

  constructor(id: number, username: string, password: string, nome: string, cognome: string) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome;
  }
}
