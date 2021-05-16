# Caixa Eletrônico

## TODO

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