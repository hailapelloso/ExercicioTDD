package br.exercicio.salario.servico;

import br.exercicio.salario.modelo.Salario;

public class FolhaPagamento {

	private Salario salario;

    public FolhaPagamento() {
    }

    public FolhaPagamento para(String descricao) {
   	 this.salario = new Salario(descricao);
   	 return this;
    }

    public FolhaPagamento queRecebePorHora(double salarioHora) {
   	 this.salario.setSalarioHora(salarioHora);
   	 return this;
    }

    public FolhaPagamento queTrabalhaEmHorasSemanais(int horas) {
      	 this.salario.setQuantidadeHorasTrabalhadas(horas);
      	 return this;
       }    
    
    public FolhaPagamento queTemComoDependente(String dependente) {
     	 this.salario.adicionaDependente(dependente);
     	 return this;
      }        
    
    public Salario constroi() {
   	 return this.salario;
    }	
}
