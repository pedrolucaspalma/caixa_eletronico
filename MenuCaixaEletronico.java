public class MenuCaixaEletronico implements Menu {
    private Registrador registrador = new Registrador();

    public void renderizarMenu() {
        // TODO: Adicionar itens de seleção
        System.out.println("");
    }

    public int lerSelecao() {
        return registrador.lerInt("> ");
    }

    public void executarSelecao(int itemSelecionado) {
        //TODO: Adicionar itens de seleção
        switch(itemSelecionado) {}
    }

    public void selecionar() {
        renderizarMenu();
        executarSelecao(lerSelecao());
    }
}
