public class MenuCaixaEletronico implements Menu {
    private Registrador registrador = new Registrador();

    // TODO: Adicionar itens de seleção
    // - Depositar
    // - Transferencias
    // - Sacar
    // - Emitir Extrato
    // - Avançar no tempo
    // - Configurar PIX
    // - Pagar boleto
    // - Encerrar sessao
    //// Digitar o codigo de barras de 48 digitos, valor e data de vencimento

    public void renderizarMenu() {
        String mensagem = """
                          |----------------------------------|\n
                          |  Bem-vindo ao caixa eletronico!  |\n
                          |----------------------------------|\n
                          | Digite um desses numeros:        |\n
                          |                                  |\n
                          | 1. Sacar                         |\n
                          | 2. Transferir                    |\n
                          | 3. Depositar                     |\n
                          | 4. Pagar Boleto                  |\n
                          | 5. Emitir Extrato                |\n
                          | 6. Avancar no Tempo              |\n
                          | 7. Configurar PIX                |\n
                          | 0. Encerrar Sessao               |\n
                          |                                  |\n
                          |----------------------------------|\n
                          """;

        System.out.println(mensagem);
    }

    public int lerSelecao() {
        return registrador.lerInt("| > ");
    }

    // Depende da função lerSelecao para executar uma função
    public void executarSelecao(int itemSelecionado) {
        //TODO: Adicionar itens de seleção
        switch(itemSelecionado) {
            case 1: {
                executar();
            }
            case 2: {
                executar();
            }
            case 3: {
                executar();
            }
            case 4: {
                executar();
            }
            case 5: {
                executar();
            }
            case 6: {
                executar();
            }
            case 7: {
                executar();
            }
            case 0: {
                return;
            }
        }
    }

    public void selecionar() {
        renderizarMenu();
        executarSelecao(lerSelecao());
    }
}
