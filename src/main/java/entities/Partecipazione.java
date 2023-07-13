package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partecipazione")
@Setter
@Getter
@NoArgsConstructor

public class Partecipazione {
	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private Stato stato;

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
}

@Override
public String toString() {
	return evento + " " + stato;
}
}
