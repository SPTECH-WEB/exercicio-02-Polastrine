# Exemplo de Design Patterns: Strategy e Adapter

## **1. Strategy**

O padrão **Strategy** é usado para definir um conjunto de services que possam ser alternados.
Ele permite que o comportamento de uma classe seja alterado em tempo de execução sem modificar o código.
Traz flexibilidade ao projeto.

### **Como utilizei no projeto:**
- O cálculo de frete é implementado usando o padrão Strategy.
- Cada modalidade de frete (por exemplo, transportadora externa) pode ter sua própria lógica de cálculo.
- A classe `FreteService` utiliza diferentes estratégias para calcular o frete com base na modalidade escolhida.

---

## **2. Adapter**

O padrão **Adapter** é usado para "adaptar" uma interface existente para que ela funcione com outra interface esperada. 
Ele é útil quando você precisa integrar sistemas ou classes que não foram projetados para trabalhar juntos.
Traz segurança, pois evita que quebre o código existente e funcional.

### **Como utilizei no projeto projeto:**
- A classe `TransportadoraExternaService` implementa o padrão Adapter.
- Ela adapta a lógica de cálculo de uma transportadora externa (`TransportadoraService`) para que seja compatível com a interface `FreteRepository` usada no sistema.

---

## **Como usar o projeto**

1. **Endpoint principal:**  
   - `GET /fretes?modalidade={modalidade}&peso={peso}`  
   Calcula o frete com base na modalidade e peso informados.

2. **Endpoint para transportadora externa:**  
   - `GET /fretes/transportadoraExterna?peso={peso}`  
   Calcula o frete utilizando a transportadora externa.