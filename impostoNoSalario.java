import java.util.Scanner;
public class impostoNoSalario {
  public static void main (String[] args) {
     Scanner input = new Scanner(System.in);
    
    float ValorHr, ImpostoDeRenda, ValorMes, SalarioBruto, inss;
      
    System.out.println("Digite o valor da hora");
    ValorHr = input.nextFloat();
    System.out.println("Digite a quantidade de horas trabalhadas");
    ValorMes = input.nextFloat();

    salariobruto = valorhr* valormes;
    inss = 100*10/salariobruto;

    if (SalarioBruto <=900 && SalarioBruto <= 1500) {
      ImpostoDeRenda = 100 * 5/SalarioBruto;
    }
    else if (SalarioBruto <=2500){
      ImpostoDeRenda = 100*10/SalarioBruto;
    }
    else {
      ImpostoDeRenda = 100*20/SalarioBruto;
    }
    
    float fgts, sind, SalarioLiquido;
    fgts = 11*100/SsalarioBruto;
    sind = 3*100/SalarioBruto;
    SalarioLiquido = SalarioBruto - ifr - fgts - sind - inss;

    System.out.println("Salário bruto: R$"+salariobruto);
    System.out.println("(-) IR: R$" +ifr);
    System.out.println("(-) INSS: R$" +inss);
    System.out.println("FGTS: R$"+fgts);
    System.out.println("Salário liquido: R$"+SalarioLiquido);

        input.close();
    }
} 
