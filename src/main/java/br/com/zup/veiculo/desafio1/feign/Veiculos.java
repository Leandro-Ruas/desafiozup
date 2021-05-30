package br.com.zup.veiculo.desafio1.feign;


import br.com.zup.veiculo.desafio1.veiculo.MarcaFeignResponse;
import br.com.zup.veiculo.desafio1.veiculo.ModelosAnosFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//url host que vamos fazer a consulta // name nome qualquer do feign
@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/", name = "veiculo")
public interface Veiculos {

    /*
     *  tipo pode ser carros, motos, ou caminhoes
     * numero da marca
     * numero modelo
     * ano do veiculo
     */
    @GetMapping(value = "{tipo}/marcas/{numeroMarca}/modelos/{numeroModel}/anos/{ano}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String consultaVeiculoCompleto(@PathVariable("tipo") String tipo,
                                         @PathVariable("numeroMarca") String numeroMarca,
                                         @PathVariable("numeroModel") String numeroModel,
                                          @PathVariable("ano") String anos);


    @GetMapping("{tipo}/marcas")
    public List<MarcaFeignResponse> consultaMarcaVeiculo(@PathVariable("tipo") String tipo);

    @GetMapping("{tipo}/marcas/{numeroMarca}/modelos")
    public ModelosAnosFeignResponse consultaModeloVeiculo(@PathVariable("tipo") String tipo,
                                                          @PathVariable("numeroMarca") String numeroMarca);

    @GetMapping("{tipo}/marcas/{numeroMarca}/modelos/{numeroModel}/anos")
    public List<MarcaFeignResponse> consultaAnoVeiculo(@PathVariable("tipo") String tipo,
                                                       @PathVariable("numeroMarca") String numeroMarca,
                                                       @PathVariable("numeroModel") String numeroModel);
}