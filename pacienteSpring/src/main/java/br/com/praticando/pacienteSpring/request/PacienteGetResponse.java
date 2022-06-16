package br.com.praticando.pacienteSpring.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PacienteGetResponse {
	private Integer idPaciente;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;


}
