import java.util.Scanner;

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
    int Colaboracao;
    float ImpostoDeRenda, SalarioBruto, SalarioLiquido, fgts = 0;
      
    //Solicita o salário bruto ao usuário
    System.out.println("Digite seu salário bruto");
    SalarioBruto = input.nextFloat();
    System.out.println("-----------------------------------------------");

    //so permite o codigo com um número válido
    do{
    //Solicita o cargo do colaborador
    System.out.println("Digite o numero correspondente com o seu cargo:");
    System.out.println("1 - Trabalhador em geral");
    System.out.println("2 - Trabalhador doméstico");
    System.out.println("3 - Jovem aprendiz");
    System.out.println("-----------------------------------------------");
    Colaboracao = input.nextInt();
    System.out.println("-----------------------------------------------");
    
    //Calcula o FGTS de acordo com o cargo do funcionário
    if (Colaboracao == 1){
        fgts = SalarioBruto * 0.08f;
     }
    else if (Colaboracao == 2){
        fgts = SalarioBruto * 0.112f;
     }
     else if (Colaboracao == 3){
        fgts = SalarioBruto * 0.02f;
     }
    else {
        System.out.println("Digite uma opção válida");
     }
    //Finaliza o loop
    } while (Colaboracao < 1 || Colaboracao > 3);
    
    /*
    * Cálculo do imposto de renda de acordo com a faixa salárial
    */
    if (SalarioBruto <=2428.8) {
      ImpostoDeRenda = 0;
     }
    else if (SalarioBruto >=2428.81 && SalarioBruto <=2826.65){
      ImpostoDeRenda = (SalarioBruto * 7.5f) / 100;
     }  
    else if (SalarioBruto >=2826.66 && SalarioBruto <=3751.05){
      ImpostoDeRenda = SalarioBruto* 0.15f;
     }
    else if (SalarioBruto >=3751.06 && SalarioBruto <=4664.68){
      ImpostoDeRenda = SalarioBruto* 0.225f;
     }
    else {
      ImpostoDeRenda = SalarioBruto*0.275f;
     }
    
    //Cálculo do salário recebido após descontos
    SalarioLiquido = SalarioBruto - ImpostoDeRenda;

    // Exibição dos resultados
    System.out.println("Salário bruto: R$"+ SalarioBruto);
    System.out.println("Salário liquido: R$"+ SalarioLiquido);
    System.out.println("Valor descontado do Imposto de Renda: R$" + ImpostoDeRenda);
    System.out.println("Valor descontado do INSS: R$");
    System.out.println("O valor do seu FGTS deve ser: R$" + fgts);
    
    // Fecha o Scanner para liberar recursos
    input.close();
    }
} 
