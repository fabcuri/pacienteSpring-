package br.com.praticando.pacienteSpring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.praticando.pacienteSpring.entities.Usuario;

import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	//obter 1 usuario de dados através do login e senha
	@Query("select u from Usuario u where u.login = :login and u.senha = :senha") Usuario findByLoginAndSenha(@Param("login")String login, @Param("senha") String senha);
	Usuario findByLogin(@Param("login") String login);

}