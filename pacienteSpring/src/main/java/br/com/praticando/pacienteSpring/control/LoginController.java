package br.com.praticando.pacienteSpring.control;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.praticando.pacienteSpring.entities.Usuario;
import br.com.praticando.pacienteSpring.repositories.IUsuarioRepository;
import br.com.praticando.pacienteSpring.request.LoginPostRequest;
import br.com.praticando.pacienteSpring.security.MD5Cryptography;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class LoginController {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	// criar endpoint
	private static final String ENDPOINT = "/api/login";

	@ApiOperation("Serviço para autenticação de Usuário.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@CrossOrigin // qqr aplicativo q queira fazer integracao com o back end consegue fazer
	public ResponseEntity<String> post(@RequestBody LoginPostRequest request) {
		try {
			// pesquisar no banco de dados o usuário através do login e senha
			Usuario usuario = usuarioRepository.findByLoginAndSenha(request.getLogin(),
					MD5Cryptography.encrypt(request.getSenha()));
			// verificar se o usuario foi encontrado
			if (usuario != null) {
				return ResponseEntity.status(HttpStatus.OK).body("Usuario autenticado com sucesso.");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
