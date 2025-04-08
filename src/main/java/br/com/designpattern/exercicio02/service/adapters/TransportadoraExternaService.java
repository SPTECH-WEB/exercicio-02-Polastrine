package br.com.designpattern.exercicio02.service.adapters;

import br.com.designpattern.exercicio02.repository.FreteRepository;
import br.com.designpattern.exercicio02.service.strategies.TransportadoraService;
import org.springframework.stereotype.Service;

@Service("transportadoraExterna")
public class TransportadoraExternaService implements FreteRepository {
    private final TransportadoraService transportadoraService;

    public TransportadoraExternaService() {
        transportadoraService = new TransportadoraService();
    }

    @Override
    public double calcular(double peso) {
        System.out.println("Calculando frete com transportadora externa...");
        return transportadoraService.calcular(peso) * 1.2;
    }

    @Override
    public String modalidade() {
        return "transportadoraExterna";
    }
}
