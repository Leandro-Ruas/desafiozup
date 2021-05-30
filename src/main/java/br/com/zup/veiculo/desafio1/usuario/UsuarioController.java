package br.com.zup.veiculo.desafio1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioRequest request,
                                    UriComponentsBuilder uriComponentsBuilder){
        Optional<Usuario> possivelUsuario =usuarioRepository.findByCpfOrEmail(request.getCpf(), request.getEmail());
        if(possivelUsuario.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF ou Email ja cadastrado no sistema");
        }
        Usuario usuario =  request.toModel();
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuario/{id}").build(usuario.getId());
        return ResponseEntity.created(uri).build();
    }
}
