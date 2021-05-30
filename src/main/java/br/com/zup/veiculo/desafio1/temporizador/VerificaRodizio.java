package br.com.zup.veiculo.desafio1.temporizador;

import br.com.zup.veiculo.desafio1.veiculo.Veiculo;
import br.com.zup.veiculo.desafio1.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Component
public class VerificaRodizio {

    @Autowired
    private VeiculoRepository veiculoRepository;


    @Scheduled(fixedDelayString = "3600000")
    public void verificaRodizio() {
        Iterable<Veiculo> lista = veiculoRepository.findAll();
        DayOfWeek data = LocalDate.now().getDayOfWeek();
        String datas = data.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("pt", "BR")).toUpperCase(Locale.ROOT);
        for (Veiculo novo: lista) {
            if(datas.equals(novo.getRodizio())){
                novo.adicionaStatus(true);
                veiculoRepository.save(novo);
            }else{
                novo.adicionaStatus(false);
                veiculoRepository.save(novo);
            }
        }
    }
}
