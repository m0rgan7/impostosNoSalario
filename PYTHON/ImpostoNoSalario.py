"""
Programa que calcula o salário líquido de um funcionário Brasileiro
com base no salário bruto.

Descontos considerados: INSS e imposto de renda

@Autor: Morgan Melo
@Versão: 3.0 (Versão em python)
@Since: 26-01-2026
"""

class Funcionario:
    def __init__(self, salario_bruto: float, colaboracao: int):
        self.salario_bruto = salario_bruto
        self.colaboracao = colaboracao


class CalculadoraSalario:
    def __init__(self, funcionario: Funcionario):
        self.funcionario = funcionario
        self.imposto_de_renda = 0.0
        self.fgts = 0.0
        self.inss = 0.0
        self.salario_liquido = 0.0

    def calcular(self):
        self.calcular_fgts()
        self.calcular_imposto_de_renda()
        self.calcular_inss()
        self.calcular_salario_liquido()
        self.exibir_resultados()

    def calcular_fgts(self):
        if self.funcionario.colaboracao == 1:
            self.fgts = self.funcionario.salario_bruto * 0.08
        elif self.funcionario.colaboracao == 2:
            self.fgts = self.funcionario.salario_bruto * 0.112
        else:
            self.fgts = self.funcionario.salario_bruto * 0.02

    def calcular_imposto_de_renda(self):
        salario = self.funcionario.salario_bruto
        self.imposto_de_renda = 0.0

        if salario > 2259.20:
            faixa = min(salario, 2826.65) - 2259.20
            self.imposto_de_renda += faixa * 0.075

        if salario > 2826.65:
            faixa = min(salario, 3751.05) - 2826.65
            self.imposto_de_renda += faixa * 0.15

        if salario > 3751.05:
            faixa = min(salario, 4664.68) - 3751.05
            self.imposto_de_renda += faixa * 0.225

        if salario > 4664.68:
            self.imposto_de_renda += (salario - 4664.68) * 0.275

    def calcular_inss(self):
        salario = self.funcionario.salario_bruto
        self.inss = 0.0

        if salario > 1621.00:
            self.inss += 1621.00 * 0.075
        else:
            self.inss += salario * 0.075
            return

        if salario > 2902.84:
            self.inss += (2902.84 - 1621.00) * 0.09
        else:
            self.inss += (salario - 1621.00) * 0.09
            return

        if salario > 4354.27:
            self.inss += (4354.27 - 2902.84) * 0.12
        else:
            self.inss += (salario - 2902.84) * 0.12

    def calcular_salario_liquido(self):
        self.salario_liquido = (
            self.funcionario.salario_bruto
            - self.imposto_de_renda
            - self.inss
        )

    def exibir_resultados(self):
        print(f"Salário bruto: R$ {self.funcionario.salario_bruto:.2f}")
        print(f"Salário líquido: R$ {self.salario_liquido:.2f}")
        print(f"Valor descontado do Imposto de Renda: R$ {self.imposto_de_renda:.2f}")
        print(f"Valor descontado do INSS: R$ {self.inss:.2f}")
        print(f"O valor do seu FGTS deve ser: R$ {self.fgts:.2f}")


def main():
    # Entrada do salário bruto
    try:
        salario_bruto = float(input("Digite seu salário bruto: "))
        print("-----------------------------------------------")
    except ValueError:
        print("Entrada inválida. Digite um número.")
        return

    colaboracao = 0

    # Loop para garantir entrada válida
    while colaboracao < 1 or colaboracao > 3:
        try:
            print("Digite o número correspondente ao seu cargo:")
            print("1 - Trabalhador em geral")
            print("2 - Trabalhador doméstico")
            print("3 - Jovem aprendiz")
            print("-----------------------------------------------")

            colaboracao = int(input())

            if colaboracao < 1 or colaboracao > 3:
                print("Entrada inválida. Digite 1, 2 ou 3.")
        except ValueError:
            print("Entrada inválida. Digite um número inteiro.")

    funcionario = Funcionario(salario_bruto, colaboracao)
    calculadora = CalculadoraSalario(funcionario)
    calculadora.calcular()


if __name__ == "__main__":
    main()
