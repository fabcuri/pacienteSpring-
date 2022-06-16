package br.com.praticando.pacienteSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="paciente")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paciente{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "idpaciente")
	private Integer idPaciente;
	
	@Column(name= "nome",length=50, nullable=false)
	private String nome;
	
	@Column(name= "cpf", nullable=false)
	private String cpf;
	
	@Column(name= "dataNascimento", nullable=false)
	private String dataNascimento;
	
	@Column(name= "sexo",length=15, nullable=false)
	private String sexo;
	
	
	
}
