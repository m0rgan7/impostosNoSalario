import java.util.Scanner;

/** 
 * Programa que calcula o salário líquido de um funcionário Brasileiro
 * com base no salário bruto.
 * 
 * Descontos considerados: sinticato, inss, ir e fgts
 * 
 * @author Morgan Melo
 * @version 1.0
 * @since 06-01-2026
 **/

public class impostoNoSalario {

  /**
   * Método principal que executa o cálculo do salário líquido.
   * 
   * @param args (não utilizados na primeira versao)
   */

  public static void main (String[] args) {

    //Scanner usado para entrada de dados via teclado
     Scanner input = new Scanner(System.in);

    //Principais variaveis
    float ImpostoDeRenda, SalarioBruto;
      
    //Solicita o salário bruto ao usuário
    System.out.println("Digite seu salário bruto");
    SalarioBruto = input.nextFloat();

    /*
    * Cálculo do imposto de renda de acordo com a faixa salárial
    */

    if (SalarioBruto <=900 && SalarioBruto <= 1500) {
      ImpostoDeRenda = (SalarioBruto * 5f) / 100;
    }
    else if (SalarioBruto <=2500){
      ImpostoDeRenda = SalarioBruto* 0.1f;
    }
    else {
      ImpostoDeRenda = SalarioBruto*0.2f;
    }
    
    //Cálculo dos demais descontos
    float sind, SalarioLiquido;
    sind = SalarioBruto * 0.03f;
    
    //Cálculo do salário recebido após descontos
    SalarioLiquido = SalarioBruto - ImpostoDeRenda - sind;

    // Exibição dos resultados
    System.out.println("Salário bruto: R$"+ SalarioBruto);
    System.out.println("(-) IR: R$" + ImpostoDeRenda);
    System.out.println("(-) INSS: R$");
    System.out.println("O valor do seu FGTS deve ser: R$");
    System.out.println("Salário liquido: R$"+ SalarioLiquido);


      // Fecha o Scanner para liberar recursos
      input.close();
    }
} 
