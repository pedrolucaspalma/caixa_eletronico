public class MenuLogin implements Menu {
    private Registrador registrador = new Registrador();

    public void renderizarMenu() {
        // TODO: Adicionar itens de seleção
        // - Abrir conta (Corrente ou poupança)
        //    - agencia sempre 001 e o numero é gerado pelo sistema
        // - Sair

        String mensagem = """
                          ------------------------------------\n
                          |  Bem-vindo ao caixa eletronico!  |\n
                          ------------------------------------\n
                          | Digite um desses numeros:        |\n
                          |                                  |\n
                          | 1. Acessar conta                 |\n
                          | 2. Abrir Conta                   |\n
                          |                                  |\n
                          | 0. Sair                          |\n
                          |                                  |\n
                          ------------------------------------\n
                          """;

        System.out.println(mensagem);
    }

    public int lerSelecao() {
        return registrador.lerInt("| > ");
    }

    public void executarSelecao(int itemSelecionado) {
        //TODO: Adicionar itens de seleção
        switch(itemSelecionado) {/*
            switch {
                case 1: {
                    acessarConta();
                    break;
                }
                case 0: {
                    return;
                }
            }
        */}
    }

    public void selecionar() {
        renderizarMenu();
        executarSelecao(lerSelecao());
    }
}
