package br.com.zup.veiculo.desafio1.veiculo;

import br.com.zup.veiculo.desafio1.feign.Veiculos;
import br.com.zup.veiculo.desafio1.usuario.Usuario;
import br.com.zup.veiculo.desafio1.usuario.UsuarioRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private Veiculos veiculos;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoController(Veiculos veiculos, UsuarioRepository usuarioRepository, VeiculoRepository veiculoRepository) {
        this.veiculos = veiculos;
        this.usuarioRepository = usuarioRepository;
        this.veiculoRepository = veiculoRepository;
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> consultaListaVeiculosPeloUsuario(@PathVariable("id") Long id){
        //consultar o usuario no banco de dados
        List<Veiculo> lista = veiculoRepository.findByUsuarioId(id);
        //se usuario nao existir retornar erro 400
        if(lista.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nao encontrou ninguem");
        }
        //se usuario existir retonar nossa lista status 200
        List<UsuarioListaVeiculoResponse> resultado = lista.stream().map(a ->
                new UsuarioListaVeiculoResponse(a)).collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }


    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid VeiculoRequest request, UriComponentsBuilder uriComponentsBuilder){
        //verificar se exite usuario com esse id
       Optional<Usuario> usuario = usuarioRepository.findById(request.getIdUsuario());
       if(usuario.isEmpty()){
           //O correto seria 404 NOT_FOUND, mas esta sendo pedido no desafio para retornar 400
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuario nao existe no sistema");
       }
        //verifica no feign e buscar as informações do veiculo
       String resultado = veiculos.consultaVeiculoCompleto(request.getTipo(),request.getNumeroMarca(), request.getNumeroModel(), request.getAno());
       //nesse ponto a tabela que vem pelo feign esta retornando uma String do servidor, acredito que sera um erro entao irei transformar essa string em json
        Gson gson = new Gson();
        VeiculoFeignResponse res = gson.fromJson(resultado, VeiculoFeignResponse.class);
       //salva esse veiculo
        Veiculo veiculo = res.toModel(usuario.get());
        verificaAnoVeiculo(veiculo);
        veiculoRepository.save(veiculo);
        //retornar o nosso header Location
        URI uri = uriComponentsBuilder.path("/veiculo/{id}").build(veiculo.getId());
        return ResponseEntity.created(uri).build();
    }

        private void verificaAnoVeiculo(Veiculo veiculo) {
            String anoVeiculo = String.valueOf(veiculo.getAnoModelo());
            if(anoVeiculo.endsWith("0") || anoVeiculo.endsWith("1")){
                veiculo.addRodizio("SEGUNDA-FEIRA");
            }else if(anoVeiculo.endsWith("2") || anoVeiculo.endsWith("3")){
                veiculo.addRodizio("TERCA-FEIRA");
            }else if(anoVeiculo.endsWith("4") || anoVeiculo.endsWith("5")){
                veiculo.addRodizio("QUARTA-FEIRA");
            }else if(anoVeiculo.endsWith("6") || anoVeiculo.endsWith("7")){
                veiculo.addRodizio("QUINTA-FEIRA");
            }else{
                veiculo.addRodizio("SEXTA-FEIRA");
            }
        }


    @GetMapping("/{tipo}")
    public ResponseEntity<?> consultaMarcaVeiculo(@PathVariable("tipo") String tipo){
        List<MarcaFeignResponse> lista = veiculos.consultaMarcaVeiculo(tipo);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{tipo}/{numeroMarca}")
    public ResponseEntity<?> consultaModeloVeiculo(@PathVariable("tipo") String tipo,
                                                   @PathVariable("numeroMarca") String numeroMarca){
        ModelosAnosFeignResponse lista = veiculos.consultaModeloVeiculo(tipo, numeroMarca);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{tipo}/{numeroMarca}/{numeroModel}")
    public ResponseEntity<?> consultaModeloVeiculo(@PathVariable("tipo") String tipo,
                                                   @PathVariable("numeroMarca") String numeroMarca,
                                                   @PathVariable("numeroModel") String numeroModel){
        List<MarcaFeignResponse> lista = veiculos.consultaAnoVeiculo(tipo, numeroMarca, numeroModel);
        return ResponseEntity.ok(lista);
    }
}
