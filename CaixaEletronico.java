import java.util.Calendar;

public class CaixaEletronico {
	private Registrador input = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	private Calendar calendar = Calendar.getInstance();

	public int lerSelecao() {
		return input.lerInt(".");
	}

	public void menuLogin() {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Acessar conta corrente\n2. Acessar conta poupanca\n3. Abrir conta corrente\n4. Abrir conta poupanca\n\n0. Sair\n\n");

		switch (lerSelecao()) {
			case 1:
				String numeroDaConta = input.lerString("Digite o numero da conta");
				String senha = input.lerString("Digite a sua senha");

				int posConta = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);

				if (posConta != -1 && contas.getContasCorrente().get(posConta).senha.equals(senha)) {
					menuContaCorrente(contas.getContasCorrente().get(posConta));
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

	public void menuContaCorrente(ContaCorrente conta) {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Sacar\n2. Depositar\n3. Emitir extrato\n4. Transferencia\n5. Configurar PIX\n6. Pagar boleto\n7. Avancar no tempo\n\n0. Encerrar Sessao\n");

		switch (lerSelecao()) {
			case 1:
				float valor = Float.parseFloat(input.lerValor("Digite o valor que deseja sacar"));
				float saldoAtual = conta.getSaldo();

				if (saldoAtual >= valor) {
					conta.setSaldo(saldoAtual - valor);
					System.out.println("Saque feito com sucesso.");
				} else {
					System.out.println("Valor indisponivel para o saque!");
				}

				menuContaCorrente(conta);
				return;
        break;
			case 2:
				float valor = Float.parseFloat(input.lerValor("Digite o valor que deseja depositar"));
				float saldoAtual = conta.getSaldo();

				conta.setSaldo(saldoAtual + valor);
				System.out.println("Deposito feito com sucesso.");
				menuContaCorrente(conta);
				break;
			case 3: // Emitir Extrato
				break;
			case 4: // Fazer transferencia atraves de (Agencia ∧ Conta) ∨ PIX
				input.lerString("Digite a agencia do remetente");
				String contaRemetente = input.lerString("Digite a numero da conta do remetente");
				int posRemetente = contas.acharContaCorrentePorNumeroDaConta(contaRemetente);
				saldoAtual = contas.getContasCorrente().get(posRemetente).getSaldo();
				valor = Float.parseFloat(input.lerValor("Digite o valor da tranferencia: "));

				contas.getContasCorrente().get(posRemetente).setSaldo(saldoAtual + valor);
				System.out.println("Tranferencia feita com sucesso.");
				menuLogin();
				break;
			case 5: // Configurar PIX ⇔ Definir qual informação será utilizada para transferências
					// (cpf, e-mail e telefone ou criando uma chave nova)
					conta.adicionarPix();
					menuContaCorrente(conta);
					break;
			case 6: // TODO: Pagar boleto (Digitando o codigo de barras de 48 digitos, valor e data
					// de vencimento)
				break;
		}
	}
}
