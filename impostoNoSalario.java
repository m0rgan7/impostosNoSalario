import java.util.Scanner;
public class impostoNoSalario {
  public static void main (String[] args) {
     Scanner input = new Scanner(System.in);
    
    float valorhr, ifr, valormes, salariobruto, inss;
      
    System.out.println("Digite o valor da hora");
    valorhr = input.nextFloat();
    System.out.println("Digite a quantidade de horas trabalhadas");
    valormes = input.nextFloat();

    salariobruto = valorhr* valormes;
    inss = 100*10/salariobruto;

    if (salariobruto <=900 && salariobruto <= 1500) {
      ifr = 100 * 5/salariobruto;
    }
    else if (salariobruto <=2500){
      ifr = 100*10/salariobruto;
    }
    else {
      ifr = 100*20/salariobruto;
    }
    
    float fgts, sind, salarioliquido;
    fgts = 11*100/salariobruto;
    sind = 3*100/salariobruto;
    salarioliquido = salariobruto - ifr - fgts - sind - inss;

    System.out.println("Salário bruto: R$"+salariobruto);
    System.out.println("(-) IR: R$" +ifr);
    System.out.println("(-) INSS: R$" +inss);
    System.out.println("FGTS: R$"+fgts);
    System.out.println("Salário liquido: R$"+salarioliquido);

        input.close();
    }
} 