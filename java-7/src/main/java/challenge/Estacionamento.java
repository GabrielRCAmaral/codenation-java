package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {

      Motorista motorista = carro.getMotorista();
      if(motorista==null){
          throw new EstacionamentoException("Carro sem motorista!");

      }
      if(motorista.getIdade()<18)
          throw new EstacionamentoException("Motorista nao tem idade para dirigir");
      if(motorista.getHabilitacao()==null)
          throw new EstacionamentoException("Motorista nao tem habilitacao");
      if(motorista.getPontos()>20)
          throw new EstacionamentoException("Habilitacao suspensa");
      if(carro.getCor()==null || carro.getPlaca()==null)
          throw new EstacionamentoException("Falta informacao do carro");
      if(carrosEstacionados()>=10){
         Carro sair = carros.stream().filter(x -> x.getMotorista().getIdade()<56).findFirst().orElseThrow(() -> new EstacionamentoException("cheio"));
         carros.remove(sair);

      }
        carros.add(carro);

    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
