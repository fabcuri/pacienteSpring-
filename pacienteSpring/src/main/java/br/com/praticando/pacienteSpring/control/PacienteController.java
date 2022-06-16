package br.com.praticando.pacienteSpring.control;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.praticando.pacienteSpring.entities.Paciente;
import br.com.praticando.pacienteSpring.repositories.IPacienteRepository;
import br.com.praticando.pacienteSpring.request.PacienteGetResponse;
import br.com.praticando.pacienteSpring.request.PacientePostRequest;
import br.com.praticando.pacienteSpring.request.PacientePutRequest;

import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class PacienteController {
	@Autowired
	private IPacienteRepository pacienteRepository;
	//metodo para
	private static final String ENDPOINT= "api/pacientes";



	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.POST)
	public ResponseEntity<String>post(@RequestBody PacientePostRequest request){
		try {
			Paciente paciente= new Paciente();
			paciente.setNome(request.getNome());
			paciente.setCpf(request.getCpf());
			paciente.setDataNascimento(request.getDataNascimento());
			paciente.setSexo(request.getSexo());
		

			pacienteRepository.save(paciente);

			return ResponseEntity.status(HttpStatus.OK).body("Paciente cadastrado com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}
	}

	@RequestMapping(value=ENDPOINT, method=RequestMethod.PUT)
	public ResponseEntity<String>put(@RequestBody PacientePutRequest request){
		try {
			
			Optional<Paciente> item= pacienteRepository.findById(request.getIdPaciente());
			if(!item.isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente não encontrado");
			}else {
				Paciente paciente= new Paciente();
				paciente.setNome(request.getNome());
				paciente.setCpf(request.getCpf());
				paciente.setDataNascimento(request.getDataNascimento());
				paciente.setSexo(request.getSexo());
				

				pacienteRepository.save(paciente);
				return ResponseEntity.status(HttpStatus.OK).body("Paciente atualizado com sucesso");

			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}
	}
	
	@RequestMapping(value=ENDPOINT + "/{idPaciente}", method=RequestMethod.DELETE)
	public ResponseEntity<String>delete(@PathVariable("idPaciente") Integer idPaciente){
		try {
			
			Optional<Paciente> item= pacienteRepository.findById(idPaciente);
			
			if(!item.isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente não encontrado");
			}else {
				Paciente paciente= item.get();
				pacienteRepository.delete(paciente);
				return ResponseEntity.status(HttpStatus.OK).body("Paciente excluido com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}

	}
	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.GET)
	public ResponseEntity<List<PacienteGetResponse>>get() {
		List<PacienteGetResponse> response= new ArrayList<PacienteGetResponse>();
		for(Paciente paciente: pacienteRepository.findAll()) {
			PacienteGetResponse item= new PacienteGetResponse();
			item.setIdPaciente(paciente.getIdPaciente());
			item.setNome(paciente.getNome());
			item.setCpf(paciente.getCpf());
			item.setDataNascimento(paciente.getDataNascimento());
			item.setSexo(paciente.getSexo());
		
		

			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	
	@RequestMapping(value=ENDPOINT + "/{idPaciente}", method=RequestMethod.GET)
	public ResponseEntity<PacienteGetResponse>getById(@PathVariable("idPaciente") Integer idPaciente) {
		Optional<Paciente> item= pacienteRepository.findById(idPaciente);
		if(!item.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			PacienteGetResponse response= new PacienteGetResponse();
			Paciente paciente= item.get();
			response.setIdPaciente(paciente.getIdPaciente());
			response.setNome(paciente.getNome());
			response.setCpf(paciente.getCpf());
			response.setDataNascimento(paciente.getDataNascimento());
			response.setSexo(paciente.getSexo());
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
	}
}