package br.com.designpattern.exercicio02.service.strategies;

import br.com.designpattern.exercicio02.repository.FreteRepository;
import org.springframework.stereotype.Component;

@Component
public class ExpressaService implements FreteRepository {
    @Override
    public double calcular(double peso){
        return peso * 2.0;
    }

    @Override
    public String modalidade(){
        return "expressa";
    }
}
