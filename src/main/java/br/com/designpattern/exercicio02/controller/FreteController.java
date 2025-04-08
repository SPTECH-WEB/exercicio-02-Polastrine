package br.com.designpattern.exercicio02.controller;

import br.com.designpattern.exercicio02.repository.FreteRepository;
import br.com.designpattern.exercicio02.service.FreteService;
import br.com.designpattern.exercicio02.service.adapters.TransportadoraExternaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService freteService;
    private final FreteRepository freteRepository;

    public FreteController(@Qualifier("transportadoraExterna") FreteRepository freteRepository, FreteService freteService){
        this.freteService = freteService;
        this.freteRepository = freteRepository;
    }

    @GetMapping
    public String calcularFrete(@RequestParam String modalidade,@RequestParam double peso){
        double valor = freteService.calcular(modalidade, peso);
        return "Frete (" + modalidade +") para " + peso + "Kg: R$ " + valor;
    }

    @GetMapping("/transportadoraExterna")
    public String calcularFreteTransportadoraExterna(@RequestParam double peso){
        double valor = freteRepository.calcular(peso);
        return "Frete (transportadoraExterna) para " + peso + "Kg: R$ " + valor;
    }

}
