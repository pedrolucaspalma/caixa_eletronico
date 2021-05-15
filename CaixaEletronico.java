public class CaixaEletronico {
	private Registrador input = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	
	public int lerSelecao() {
		return input.lerInt(".");
	}

	public void menuLogin() {
		System.out.printf
		(
			"\n=== Bem-vindo ao caixa eletronico!\n\nDigite um desses numeros:\n\n1. Acessar conta corrente\n2. Acessar conta poupanca\n3. Abrir conta corrente\n4. Abrir conta poupanca\n\n0. Sair\n\n"
		);

		switch(lerSelecao()) {
			case 1:
				String numeroDaConta = input.lerString("Digite o numero da conta");
				if (contas.acharContaCorrentePorNumeroDaConta(numeroDaConta) != -1) {
					menuContaCorrente();
				} else {
					System.out.println("Conta nao esta cadastrada");
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
		System.out.printf
		(
			"Digite um desses numeros:\n\n1. Sacar\n2. Transferir\n3. Depositar\n4. Pagar Boleto\n5. Emitir Extrato\n6. Avancar no Tempo\n7. Configurar PIX\n\n0. Encerrar Sessao\n"
		);

		switch(lerSelecao()) {
			case 3:
				break;
			case 4:
				break;
		}
	}
}