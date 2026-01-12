import java.util.Scanner;
import java.util.InputMismatchException;
/** 
 * Programa que calcula o salário líquido de um funcionário Brasileiro
 * com base no salário bruto.
 * 
 * Descontos considerados: inss e imposto de renda
 * 
 * @author Morgan Melo
 * @version 1.0
 * @since 06-01-2026
 **/

public class ImpostoNoSalario {

  /**
   * Método principal que executa o cálculo do salário líquido.
   * 
   * @param args (não utilizados na primeira versao)
   */

  public static void main (String[] args) {

    //Scanner usado para entrada de dados via teclado
    Scanner input = new Scanner(System.in);

    //Principais variaveis
    int colaboracao = 0;
    float impostoDeRenda, salarioBruto, salarioLiquido, fgts = 0;
      
    //Solicita o salário bruto ao usuário
    System.out.println("Digite seu salário bruto");
    salarioBruto = input.nextFloat();
    System.out.println("-----------------------------------------------");
    
    do{ //so permite o codigo com um número válido
    
        //Trata exceção para entrada inválida
        try {

            //Solicita o cargo do colaborador
            System.out.println("Digite o numero correspondente com o seu cargo:");
            System.out.println("1 - Trabalhador em geral");
            System.out.println("2 - Trabalhador doméstico");
            System.out.println("3 - Jovem aprendiz");
            System.out.println("-----------------------------------------------");
            colaboracao = input.nextInt();
            System.out.println("-----------------------------------------------");

            break; // Sai do loop se a entrada for válida
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            input.next(); // Limpa a entrada inválida
        }

    //Finaliza o loop
    } while (colaboracao < 1 || colaboracao > 3);
    
     //Calcula o FGTS de acordo com o cargo do funcionário
    if (colaboracao == 1){
        fgts = salarioBruto * 0.08f;
     }
    else if (colaboracao == 2){
        fgts = salarioBruto * 0.112f;
     }
     else {
        fgts = salarioBruto * 0.02f;
     }

    /*
    * Cálculo do imposto de renda de acordo com a faixa salárial
    */
    if (salarioBruto <=2428.8) {
      impostoDeRenda = 0;
     }
    else if (salarioBruto >=2428.81 && salarioBruto <=2826.65){
      impostoDeRenda = (salarioBruto * 7.5f) / 100;
     }  
    else if (salarioBruto >=2826.66 && salarioBruto <=3751.05){
      impostoDeRenda = salarioBruto* 0.15f;
     }
    else if (salarioBruto >=3751.06 && salarioBruto <=4664.68){
      impostoDeRenda = salarioBruto* 0.225f;
     }
    else {
      impostoDeRenda = salarioBruto*0.275f;
     }
    
    //Cálculo do salário recebido após descontos
    salarioLiquido = salarioBruto - impostoDeRenda;

    // Exibição dos resultados
    System.out.println("Salário bruto: R$"+ salarioBruto);
    System.out.println("Salário liquido: R$"+ salarioLiquido);
    System.out.println("Valor descontado do Imposto de Renda: R$" + impostoDeRenda);
    System.out.println("Valor descontado do INSS: R$");
    System.out.println("O valor do seu FGTS deve ser: R$" + fgts);
    
    input.close(); // Fecha o Scanner para liberar recursos
    }
}