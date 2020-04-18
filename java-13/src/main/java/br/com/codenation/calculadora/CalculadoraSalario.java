package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if(salarioBase<1039)
			return Math.round(0.0);

		double taxaInss=calcularInss(salarioBase);
		double salarioLiqInss = descontarSalario(salarioBase,taxaInss);
		double taxaIRRF=calcularIrrf(salarioLiqInss);
		return Math.round(descontarSalario(salarioLiqInss,taxaIRRF));
	}
	
	private double descontarSalario(double salarioBase,double taxa){
		return salarioBase - (salarioBase*taxa);
	}
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double taxa=0;
		if(salarioBase<=1500){
			taxa=0.08;
		}
		else if(salarioBase<=4000){
			taxa=0.09;
		}
		else {
			taxa = 0.11;
		}
		return taxa;
	}

	private double calcularIrrf(double salarioBase){
		double taxa=0;
		if(salarioBase<=3000){
			taxa=0;
		}
		else if(salarioBase<=6000){
			taxa=0.075;
		}
		else {
			taxa=0.15;
		}

		return taxa;

	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/