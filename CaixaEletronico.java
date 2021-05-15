import java.util.Calendar;

public class CaixaEletronico {
	private Registrador input = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	private Calendar calendar = Calendar.getInstance();

	String numeroDaConta;

	public int lerSelecao() {
		return input.lerInt(".");
	}

	public void menuLogin() {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Acessar conta corrente\n2. Acessar conta poupanca\n3. Abrir conta corrente\n4. Abrir conta poupanca\n\n0. Sair\n\n");

		switch (lerSelecao()) {
			case 1:
				numeroDaConta = input.lerString("Digite o numero da conta");
				String senha = input.lerString("Digite a sua senha");

				int posConta = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);

				if (posConta != -1 && contas.getContasCorrente().get(posConta).senha.equals(senha)) {
					menuContaCorrente();
				} else {
					System.out.printf("\nDados invalidos\n\n");
				}

				menuLogin();
				break;
			case 3:
				contas.abrirContaCorrente();
				menuLogin();
				break;
			case 4:
				contas.abrirContaPoupanca();
				menuLogin();
				break;
			case 0:
				return;
		}
	}

	public void menuContaCorrente() {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Sacar\n2. Transferir\n3. Depositar\n4. Pagar Boleto\n5. Emitir Extrato\n6. Avancar no Tempo\n7. Configurar PIX\n\n0. Encerrar Sessao\n");

		switch (lerSelecao()) {
			case 1: // TODO: Sacar
				int pos = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);
				float valor = Float.parseFloat(input.lerValor("Digite o valor que deseja sacar: "));
				float saldoAtual = contas.getContasCorrente().get(pos).getSaldo();
				if (saldoAtual >= valor) {
					contas.getContasCorrente().get(pos).setSaldo(saldoAtual - valor);
					System.out.println("Saque feito com sucesso.");
				} else {
					System.out.println("Valor indisponivel para o saque!");
				}

				break;
			case 2: // TODO: Depositar
				break;
			case 3: // Emitir Extrato
				break;
			case 4: // Fazer transferencia atraves de (Agencia ∧ Conta) ∨ PIX
				break;
			case 5: // Configurar PIX ⇔ Definir qual informação será utilizada para transferências
					// (cpf, e-mail e telefone ou criando uma chave nova)
				break;
			case 6: // TODO: Pagar boleto (Digitando o codigo de barras de 48 digitos, valor e data
					// de vencimento)
				break;
		}
	}
}
