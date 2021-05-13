# Caixa Eletrônico

## Roadmap

- [ ] Implementar função de cadastrar usuarios e integrar ao menu de login;











































<!-->
## Tomorrow

- [ ] Adicionar itens ao menu;
- [ ] Começar a implementar os itens que o menu deve executar;

## Separação

- Verificar e criar coisas (fazer os construtores)
- Transferencias e extratos
- Saldo, PIX e boletos

## To-Do

- [x] Verificar Email, telefone ...
- [ ] Abrir conta corrente ou poupança ( CPF, data de nascimento, e-mail, telefone e senha )
    - [ ] Caso você tenha uma conta corrente, o sistema não deve requerer novamente os dados pessoais para abrir uma conta poupança (e vice-versa)
    - [ ] A agência será sempre 0001 e o número da conta deve ser gerado pelo sistema
    - [ ] Tanto conta corrente quanto poupança podem ser conta-salário (o valor do salário e data de pagamento devem ser definidos neste caso)
- [ ] Fazer depositos e saques em contas
    - [ ] A conta corrente terá um limite de cheque especial no valor de R$3000,00
- [ ] Emitir extratos de contas
    - [ ] Para cada linha do extrato a data, o tipo de operação, descrição e o valor devem ser exibidos
    - [ ] O sistema deve permitir selecionar um item do extrato para mostrar todos os detalhes. Exemplo: caso o item do extrato seja um pagamento de boleto, sistema deve mostrar todas as suas informações (código de barras, valor, data e multa)
- [ ] Atualizar mensalmente o saldo da conta poupança coom o rendimento rendimento de 0,3%
- [ ] fazer transferência entre contas por meio da agência e conta ou através do “PIX”
- [ ] configurar o PIX, definindo qual informação será utilizada para transferência (cpf, e-mail e telefone ou criando uma chave nova)
- [ ] pagar boletos (digitando o código de barras de 48 dígitos, valor e data de vencimento)
    - [ ] Caso esteja em atraso, o sistema deve aplicar multa de 0,1% ao dia

## Aspectos adicionais

- [ ] Você deve implementar as classes de conta utilizando os conceitos de herança e classe abstrata
- [ ] Você deve utilizar uma interface TransacaoEmConta para definir o contrato básico de um item do extrato com os métodos getValor(), getDescricao(), getTipoOpercao e getData()
- [ ] O sistema deve guardar o dia atual e permitir “avançar no tempo” (em dias), para poder refletir nos cálculos de rendimento de poupança, cálculo de poupança e salário. O mecanismo de “avanço no tempo” pode ser utilizado várias vezes
  - [ ] Entrada de conta de salário deve ser simulada mês a mês conforme o valor do salário e data de pagamento
<--->
