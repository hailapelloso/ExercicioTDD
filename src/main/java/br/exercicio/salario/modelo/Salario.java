package br.exercicio.salario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Salario {
	private String funcionario;
	private int quantidadeHorasTrabalhadas;
	private double salarioHora;
	private List<String> dependentes;
	
	public Salario(String funcionario){
		setFuncionario(funcionario);
		setDependentes(new ArrayList<String>());
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}	

	public int getQuantidadeHorasTrabalhadas() {
		return quantidadeHorasTrabalhadas;
	}

	public void setQuantidadeHorasTrabalhadas(int quantidadeHorasTrabalhadas) {
		this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

    public void adicionaDependente(String dependente) {
    	this.dependentes.add(dependente);
    }
    
	public int getNumeroDependentes() {
		return dependentes.size();
	}    
	
	public double getSalarioBruto(){
		return getQuantidadeHorasTrabalhadas() * getSalarioHora() + (50 * getNumeroDependentes());
	}
	
	public double getDescontoInss(){
		double salarioBruto = getSalarioBruto();
		double descontoInss;
		if (salarioBruto <= 1000){
			descontoInss = salarioBruto * 8.5 / 100;
		}
		else {
			descontoInss = salarioBruto * 9 / 100;
		}
		
		return descontoInss;
	}
	
	public double getDescontoIr(){
		double salarioBruto = getSalarioBruto();
		double descontoIr = 0;
		if (salarioBruto > 500 && salarioBruto < 1000){
			descontoIr = salarioBruto * 5 / 100;
		}
		else if (salarioBruto > 1000) {
			descontoIr = salarioBruto * 7 / 100;
		}
		
		return descontoIr;
	}	
	
	public double getSalarioLiquido(){
		return getSalarioBruto() - getDescontoInss() - getDescontoIr();
	}

	public List<String> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<String> dependentes) {
		this.dependentes = dependentes;
	}

}
