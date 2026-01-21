class CalculadoraSalario {

    private Funcionario funcionario;
    private float impostoDeRenda;
    private float fgts;
    private float inss;
    private float salarioLiquido;

    CalculadoraSalario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void calcular() {
        calcularFGTS();
        calcularImpostoDeRenda();
        calcularINSS();
        calcularSalarioLiquido();
        exibirResultados();
    }

    private void calcularFGTS() {
        if (funcionario.colaboracao == 1) {
            fgts = funcionario.salarioBruto * 0.08f;
        } else if (funcionario.colaboracao == 2) {
            fgts = funcionario.salarioBruto * 0.112f;
        } else {
            fgts = funcionario.salarioBruto * 0.02f;
        }
    }

    private void calcularImpostoDeRenda() {
        float salario = funcionario.salarioBruto;

        if (salario > 2259.20f) {
        float faixa = Math.min(salario, 2826.65f) - 2259.20f;
        impostoDeRenda += faixa * 0.075f;
    }

    if (salario > 2826.65f) {
        float faixa = Math.min(salario, 3751.05f) - 2826.65f;
        impostoDeRenda += faixa * 0.15f;
    }

    if (salario > 3751.05f) {
        float faixa = Math.min(salario, 4664.68f) - 3751.05f;
        impostoDeRenda += faixa * 0.225f;
    }

    if (salario > 4664.68f) {
        impostoDeRenda += (salario - 4664.68f) * 0.275f;
    }
   }

    //Cálculo do INSS
    private void calcularINSS() {
        float salario = funcionario.salarioBruto;
        inss = 0;

        if (salario > 1621.00f) {
            inss += 1621.00f * 0.075f;
        } else {
            inss += salario * 0.075f;
            return;
        }

        if (salario > 2902.84f) {
            inss += (2902.84f - 1621.00f) * 0.09f;
        } else {
            inss += (salario - 1621.00f) * 0.09f;
            return;
        }

        if (salario > 4354.27f) {
            inss += (4354.27f - 2902.84f) * 0.12f;
        } else {
            inss += (salario - 2902.84f) * 0.12f;
        }
    }

    private void calcularSalarioLiquido() {
        salarioLiquido = funcionario.salarioBruto - impostoDeRenda - inss;
    }

    private void exibirResultados() {
        System.out.println("Salário bruto: R$ " + funcionario.salarioBruto);
        System.out.println("Salário liquido: R$ " + salarioLiquido);
        System.out.println("Valor descontado do Imposto de Renda: R$ " + impostoDeRenda);
        System.out.println("Valor descontado do INSS: R$ " + inss);
        System.out.println("O valor do seu FGTS deve ser: R$ " + fgts);
    }
}
