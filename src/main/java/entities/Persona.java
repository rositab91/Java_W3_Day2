package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persone")
@Setter
@Getter
@NoArgsConstructor

public class Persona {

	@Id
	@GeneratedValue
	private UUID id;

	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataDiNascita;

	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToMany(mappedBy = "persona")
	@OrderBy("data DESC")
	private Set<Partecipazione> partecipazione;

	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			Set<Partecipazione> partecipazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.email = email;
		this.sesso = sesso;
		this.partecipazione = partecipazione;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " " + dataDiNascita + " " + email + " " + sesso;
	}
}
