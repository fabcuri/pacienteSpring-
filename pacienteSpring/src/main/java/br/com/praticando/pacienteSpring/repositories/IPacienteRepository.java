package br.com.praticando.pacienteSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.praticando.pacienteSpring.entities.Paciente;





	@Repository
	public interface IPacienteRepository extends CrudRepository<Paciente,Integer>{

	}
