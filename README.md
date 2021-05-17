# Caixa Eletrônico

## TODO

Tirar cheque especial da conta poupança
Add mensagem de PIX cadastrado com sucesso

### DOING


## DONE

- [x] Entrada de conta de salário deve ser simulada mês a mês conforme o valor do salário e data de pagamento
- [x] Tanto conta corrente quanto poupança podem ser conta-salário (o valor do salário e data de pagamento devem ser definidos neste caso)
- [x] fazer transferência entre contas por meio da agência e conta ou através do “PIX”
- [x] Atualizar mensalmente o saldo da conta poupança com o rendimento rendimento de 0,3%
- [x] O sistema deve permitir selecionar um item do extrato para mostrar todos os detalhes. Exemplo: caso o item do extrato seja um pagamento de boleto, sistema deve mostrar todas as suas informações (código de barras, valor, data e multa)
- [x] pagar boletos (digitando o código de barras de 48 dígitos, valor e data de vencimento)
    - [x] Caso esteja em atraso, o sistema deve aplicar multa de 0,1% ao dia
- [x] Você deve utilizar uma interface TransacaoEmConta para definir o contrato básico de um item do extrato com os métodos getValor(), getDescricao(), getTipoOpercao e getData()
- [x] O sistema deve guardar o dia atual e permitir “avançar no tempo” (em dias), para poder refletir nos cálculos de rendimento de poupança, cálculo de poupança e salário. O mecanismo de “avanço no tempo” pode ser utilizado várias vezes
- [x] configurar o PIX, definindo qual informação será utilizada para transferência (cpf, e-mail e telefone ou criando uma chave nova)
- [x] Emitir extratos de contas
    - [x] Para cada linha do extrato a data, o tipo de operação, descrição e o valor devem ser exibidos
- [x] Abrir conta corrente ou poupança ( CPF, data de nascimento, e-mail, telefone e senha )
    - [x] Caso você tenha uma conta corrente, o sistema não deve requerer novamente os dados pessoais para abrir uma conta poupança (e vice-versa)
    - [x] A agência será sempre 0001 e o número da conta deve ser gerado pelo sistema
- [x] Fazer depositos e saques em contas
    - [x] A conta corrente terá um limite de cheque especial no valor de R$3000,00
- [x] Você deve implementar as classes de conta utilizando os conceitos de herança e classe abstrata

## Roteiro

### Registrador
Classe que cuida de entrada e verificação de dados. Nela temos métodos como lerInteiro, LerFloat e outros tipos de inputs que utilizamos com frequência durante o código.

### Conta
Classe abstrata que age como molde para ContaCorrente e ContaPoupança. Possui atributos que serão comuns aos dois tipos de conta.

A implementação de PIX foi feita como um arraylist de Strings que é atributo de Conta. Caso a string inserida (CPF, Email, ou telefone) esteja nesse arraylist, ele é um pix daquela conta.

Além dos gets e sets, a classe possui os métodos pagarBoleto(), sacar(), depositar(), adicionarPix(), transferirPorTed() e transferirPorPix(), imprimirExtrato(), ativarContaSalario(), atualizarSalario().

#### Salario
A implementação de conta salário foi feita como um atributo na classe Conta. Esse atributo é composto de um objeto Salario que contém um booleano, um valor de pagamento e uma data de pagamento. Quando a conta (poupança ou corrente) é criada, esse objeto é iniciado como "false, 0, dataAtual", e depois o objeto é atualizado quando o usuário decide de fato ativar a conta salário.

#### Transacao
    Os métodos sacar(), depositar(), adicionarPix(), transferirPorTed() e transferirPorPix() geram objetos Transacao quando chamados. Esses objetos são armazenados num arrayList de transações, que é iterado no imprimirExtrato()

### TransacaoEmConta
    Interface que dita os métodos get() que serão implementados na classe Transacao

### ContaCorrente e ContaPoupança
    Classes que herdam de Conta. Cada objeto contaPoupança ou contaCorrente representa uma conta diferente.

### BancoDeContas
    Classe que armazena todos os objetos ContaPoupança no arraylist contasPoupança e idem para contaCorrente.

    Possui métodos de busca de contas por parâmetro (cpf, numero...) e métodos de abertura de conta
### CaixaEletronico
    Classe que lida com os menus e avança no tempo.

## Testes

    Considerar que já há uma conta corrente (numero 0) e uma conta poupança (numero 1)

    Entrar na conta corrente

    Ativar conta salario

    Avançar 32 dias

    Ativar o pix (CPF)

    Entrar na conta poupança

    Depositar 500 reais

    Enviar pix para conta corrente de 500 reais (Digitar o CPF)

    Sacar 3000 (vai dar erro)

    Pagar Boleto 100 reais 25/06/2021

    Emitir extrato

    Ver detalhe de um item

## ja feito ignorar
1. Adicionar uma conta corrente

2. Adicionar conta poupança logado na conta corrente (ele não deve requerer os dados de novo)

3. Fazer a conta corrente ativar a conta salário

    3.1.Simular pagamento

4. Mostrar rendimento na conta poupança

5. Na conta poupança:

    5.1. Depositar 500 reais

    5.2. Sacar 1000 reais (Saldo precisará ser -500 reais)

    5.3. Sacar 2600 (Deverá ser impedido)

    5.4. Depositar 1500 reais (Saldo precisará ser 1000 reais)

    5.5. Transferir 100 reais para Conta Corrente por TED

    5.6. Adicionar CPF como pix

    5.7. Adicionar CPF como pix (deverá ser impedido)

6. Na conta Corrente:

    6.1. Adicionar CPF como pix (deverá ser impedido)

    6.2. Adicionar telefone como pix

7. Na conta poupança:

    7.1. Transferir 100 reais para Conta Corrente por pix (Selecionar pix errado, devera ser impedido)

    7.2. Tentar transferir para si mesmo

    7.3. Pagar boleto de 100 reais (sem multa)

    7.4. Pagar boleto de 100 reais (com 1 dia de multa)

    7.5. Gerar extrato

    7.6. Olhar item do extrato

8. Na conta corrente:

    8.1. Olhar se Transferencias recebidas aparecem no extrato
