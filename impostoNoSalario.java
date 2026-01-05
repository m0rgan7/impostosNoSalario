import java.util.Scanner;
public class impostoNoSalario {
  public static void main (String[] args) {
     Scanner input = new Scanner(System.in);
    
    float ValorHr, ImpostoDeRenda, ValorMes, SalarioBruto, inss;
      
    System.out.println("Digite o valor da hora");
    ValorHr = input.nextFloat();
    System.out.println("Digite a quantidade de horas trabalhadas no mês");
    ValorMes = input.nextFloat();

    SalarioBruto = ValorHr* ValorMes;
    inss = 100*10/SalarioBruto;

    if (SalarioBruto <=900 && SalarioBruto <= 1500) {
      ImpostoDeRenda = 100 * (5/SalarioBruto);
    }
    else if (SalarioBruto <=2500){
      ImpostoDeRenda = 100*(10/SalarioBruto);
    }
    else {
      ImpostoDeRenda = 100*(20/SalarioBruto);
    }
    
    float sind, SalarioLiquido;
        sind = 3*100/SalarioBruto;
    SalarioLiquido = SalarioBruto - ImpostoDeRenda - sind - inss;

    System.out.println("Salário bruto: R$"+SalarioBruto);
    System.out.println("(-) IR: R$" +ImpostoDeRenda);
    System.out.println("(-) INSS: R$" +inss);
    System.out.println("O valor do seu FGTS deve ser: R$");
    System.out.println("Salário liquido: R$"+SalarioLiquido);

        input.close();
    }
} 
