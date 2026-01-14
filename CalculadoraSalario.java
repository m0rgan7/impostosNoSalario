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

        if (salario <= 2428.80f) {
            impostoDeRenda = 0;
        } else if (salario <= 2826.65f) {
            impostoDeRenda = salario * 0.075f;
        } else if (salario <= 3751.05f) {
            impostoDeRenda = salario * 0.15f;
        } else if (salario <= 4664.68f) {
            impostoDeRenda = salario * 0.225f;
        } else {
            impostoDeRenda = salario * 0.275f;
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
