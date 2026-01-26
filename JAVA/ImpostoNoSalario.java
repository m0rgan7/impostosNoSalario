import java.util.Scanner;
import java.util.InputMismatchException;
/** 
 * Programa que calcula o salário líquido de um funcionário Brasileiro
 * com base no salário bruto.
 * 
 * Descontos considerados: inss e imposto de renda
 * 
 * @author Morgan Melo
 * @version 2.0 (POO aplicado)
 * @since 06-01-2026
 **/

public class ImpostoNoSalario {

  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);

    int colaboracao = 0;
    float salarioBruto;
    
    //trata exceção para entrada inválida
    try {

      //Solicita o salário bruto do colaborador
      System.out.println("Digite seu salário bruto");
      salarioBruto = input.nextFloat();
      System.out.println("-----------------------------------------------");

    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número.");
      input.close();
      return; //encerra o programa se a entrada for inválida
      //ve como ficaria no site, pois aq so tem que rodar dnv, mas talvez precise de um loop
    }

    do { //Garante uma entrada válida e trata exceções para entrada inválida

        try {
            //Solicita o cargo do colaborador
            System.out.println("Digite o numero correspondente com o seu cargo:");
            System.out.println("1 - Trabalhador em geral");
            System.out.println("2 - Trabalhador doméstico");
            System.out.println("3 - Jovem aprendiz");
            System.out.println("-----------------------------------------------");
            colaboracao = input.nextInt();
            System.out.println("-----------------------------------------------");

            if (colaboracao < 1 || colaboracao > 3) {
                System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            input.next(); // Limpa a entrada inválida
        }
      } while (colaboracao < 1 || colaboracao > 3);

    Funcionario funcionario = new Funcionario(salarioBruto, colaboracao);
    CalculadoraSalario calculadora = new CalculadoraSalario(funcionario);
    
    calculadora.calcular();

    input.close();
    }
}