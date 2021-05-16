import java.text.DecimalFormat;
import java.time.LocalDate;

public class CaixaEletronico {
	private Registrador registrador = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	private LocalDate data = LocalDate.now();

	public int lerSelecao() {
		return registrador.lerInt(".");
	}

	public void avancarTempo(int dias) {
		LocalDate antigaData = data;
		data = data.plusDays(dias);

		for (ContaPoupanca conta : contas.getContasPoupanca()) {
			conta.atualizarRendimento(antigaData, data);
			if (conta.salario.getAtiva()) {
				conta.atualizarSalario(antigaData, data);
			}
		}

		for (ContaCorrente conta : contas.getContasCorrente()) {
			if (conta.salario.getAtiva()) {
				conta.atualizarSalario(antigaData, data);
			}
		}
	}

	public void loginContaCorrente() {
		String numeroDaConta = registrador.lerString("Digite o numero da conta");
		String senha = registrador.lerString("Digite a sua senha");

		int posConta = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);

		if (posConta != -1 && contas.getContasCorrente().get(posConta).senha.equals(senha)) {
			menuContaCorrente(contas.getContasCorrente().get(posConta));
		} else {
			System.out.printf("\nDados invalidos\n\n");
		}
	}

	public void loginContaPoupanca() {
		String numeroDaConta = registrador.lerString("Digite o numero da conta");
		String senha = registrador.lerString("Digite a sua senha");

		int posConta = contas.acharContaPoupancaPorNumeroDaConta(numeroDaConta);

		if (posConta != -1 && contas.getContasPoupanca().get(posConta).senha.equals(senha)) {
			menuContaPoupanca(contas.getContasPoupanca().get(posConta));
		} else {
			System.out.printf("\nDados invalidos\n\n");
		}
	}

	public void menuLogin() {
		System.out.println(
				"Digite um desses numeros:\n\n" +
				"1. Acessar conta corrente\n" +
				"2. Acessar conta poupanca\n" +
				"3. Abrir conta corrente\n" +
				"4. Abrir conta poupanca\n" +
				"5. Avancar no tempo\n\n" +
				"0. Sair\n"
		);

		switch (lerSelecao()) {
			case 1:
				loginContaCorrente();
				menuLogin();
				return;
			case 2:
				loginContaPoupanca();
				menuLogin();
				return;
			case 3:
				contas.abrirContaCorrente(data);
				menuLogin();
				return;
			case 4:
				contas.abrirContaPoupanca(data);
				menuLogin();
				return;
			case 5:
				avancarTempo(registrador.lerInt("Digite o numero de dias que deseja avancar"));
				menuLogin();
				return;
			case 0:
				return;
		}
	}

	public void menuContaPoupanca(ContaPoupanca conta) {
		DecimalFormat formatacaoDecimal = new DecimalFormat("0.00");
		System.out.printf("\nOla, %s\nTipo de conta: Poupanca\nSaldo: %s\n\n", conta.getNome(), formatacaoDecimal.format(conta.getSaldo()));
		System.out.println(
				"Digite um desses numeros:\n\n" +
				"1. Sacar\n" + 
				"2. Depositar\n" +
				"3. Emitir extrato\n" +
				"4. Transferencia\n" +
				"5. Configurar PIX\n" +
				"6. Pagar boleto\n" +
				"7. Ativar conta salario\n\n" +
				"0. Encerrar Sessao\n"
		);

		switch (lerSelecao()) {
			case 1: // Sacar
				conta.sacar(data);
				menuContaPoupanca(conta);
				return;
			case 2: // Depositar
				conta.depositar(data);
				menuContaPoupanca(conta);
				return;
			case 3: // Emitir Extrato
				conta.imprimirExtrato();
				menuContaPoupanca(conta);
				return;
			case 4: // Fazer transferencia atraves de (Agencia ∧ Conta) ∨ PIX
				menuTransferencia(conta);
				menuContaPoupanca(conta);
				return;
			case 5: // Configurar PIX ⇔ Definir qual informação será utilizada para transferências
				conta.adicionarPix(contas);
				menuContaPoupanca(conta);
				return;
			case 6: // Pagar boleto (Digitando o codigo de barras de 48 digitos, valor e data de vencimento)
				conta.pagarBoleto(data);
				return;
			case 7:
				if(conta.salario.getAtiva() == false){
					conta.ativarContaSalario(conta);
					System.out.println("Conta Salario ativada com sucesso.");
				} else{
					System.out.println("A conta ja e conta salario. Operacao encerrada.");
				}
				return;
			case 0 :
				return;
			default:
				System.out.println("Input Invalido!");
				menuContaPoupanca(conta);
				return;
		}
	}

	public void menuTransferencia(Conta conta) {
		System.out.println(
				"Digite um desses numeros:\n\n" +
				"1. Transferencia PIX\n" +
				"2. Transferencia TED\n\n" +
				"0. Cancelar\n"
		);

		switch(registrador.lerInt(".")) {
			case 1: {
				String chavePIX = registrador.lerString("Digite a chave PIX do destinatario");

				int indexCC = contas.acharContaCorrentePorPIX(chavePIX);
				int indexCP = contas.acharContaPoupancaPorPIX(chavePIX);
				
				if (indexCC != -1) {
					Float valor = registrador.lerFloat("Digite o valor que deseja transferir");
					ContaCorrente destinatario = contas.getContasCorrente().get(indexCC);
					conta.transferirPorPIX(destinatario, valor, data);
				} else if (indexCP != -1) {
					Float valor = registrador.lerFloat("Digite o valor que deseja transferir");
					ContaPoupanca destinatario = contas.getContasPoupanca().get(indexCP);
					conta.transferirPorPIX(destinatario, valor, data);
				} else {
					System.out.println("Chave PIX nao encontrada");
				}
				return;
			}
			case 2: {
				String agencia = registrador.lerString("Digite a agencia da conta do destinatario");
				if (agencia.equals("0001")) {
					String numeroDaConta = registrador.lerString("Digite o numero da conta do destinatario");
					
					int indexCC = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);
					int indexCP = contas.acharContaPoupancaPorNumeroDaConta(numeroDaConta);
					
					if (indexCC != -1) {
						Float valor = registrador.lerFloat("Digite o valor que deseja transferir");
						ContaCorrente destinatario = contas.getContasCorrente().get(indexCC);
						conta.transferirPorTED(destinatario, valor, data);
					} else if (indexCP != -1) {
						Float valor = registrador.lerFloat("Digite o valor que deseja transferir");
						ContaPoupanca destinatario = contas.getContasPoupanca().get(indexCP);
						conta.transferirPorTED(destinatario, valor, data);
					} else {
						System.out.println("\nNumero da conta nao encontrado\n");
					}
				} else {
					System.out.println("\nConta nao existente\n");
				}
				return;
			}
		}
	}

	public void menuContaCorrente(ContaCorrente conta) {
		DecimalFormat formatacaoDecimal = new DecimalFormat("0.00");
		System.out.printf("\nOla, %s\nTipo de conta: Corrente\nSaldo: %s\n\n", conta.getNome(), formatacaoDecimal.format(conta.getSaldo()));
		System.out.println(
				"Digite um desses numeros:\n\n" + 
				"1. Sacar\n" +
				"2. Depositar\n" +
				"3. Emitir extrato\n" +
				"4. Transferencia\n" +
				"5. Configurar PIX\n" +
				"6. Pagar boleto\n" +
				"7. Ativar conta salario\n\n" +
				"0. Encerrar Sessao\n"
		);

		switch (lerSelecao()) {
			case 1: // Sacar
				conta.sacar(data);
				menuContaCorrente(conta);
				return;
			case 2: // Depositar
				conta.depositar(data);
				menuContaCorrente(conta);
				return;
			case 3: // Emitir Extrato
				conta.imprimirExtrato();
				menuContaCorrente(conta);
				return;
			case 4:
				menuTransferencia(conta);
				menuContaCorrente(conta);
				return;
			case 5:
				conta.adicionarPix(contas);
				menuContaCorrente(conta);
				return;
			case 6:
				conta.pagarBoleto(data);
				menuContaCorrente(conta);
				return;
			case 7:
				if(conta.salario.getAtiva() == false){
					conta.ativarContaSalario(conta);
					System.out.println("Conta Salario ativada com sucesso.");
				} else{
					System.out.println("A conta ja e conta salario. Operacao encerrada.");
				}
				menuContaCorrente(conta);
				return;
			case 0 :
				return;
			default:
				System.out.println("Input Invalido!");
				menuContaCorrente(conta);
				return;
		}
	}
}