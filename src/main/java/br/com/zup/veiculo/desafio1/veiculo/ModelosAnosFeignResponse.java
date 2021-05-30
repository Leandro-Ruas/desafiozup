package br.com.zup.veiculo.desafio1.veiculo;

import java.util.List;

public class ModelosAnosFeignResponse {

    private List<AnosResponse> anos;

    private List<ModeloResponse> modelos;

    @Deprecated
    public ModelosAnosFeignResponse() {
    }

    public ModelosAnosFeignResponse(List<AnosResponse> anos, List<ModeloResponse> modelos) {
        this.anos = anos;
        this.modelos = modelos;
    }

    public List<AnosResponse> getAnos() {
        return anos;
    }

    public List<ModeloResponse> getModelos() {
        return modelos;
    }

    @Override
    public String toString() {
        return "ModelosAnosFeignResponse{" +
                "anos=" + anos +
                ", modelos=" + modelos +
                '}';
    }
}
