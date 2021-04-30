public class Caixa{
    public void criarContaCorrente(){
        ContaCorrente conta = new ContaCorrente(
            Registrador.lerString("Insira seu cpf: "), //CPF
            Registrador.lerData("\nInsira sua data de Nascimento: "), //Data de nascimento
            Registrador.lerString("\nInsira seu email: "), //Email -------> Criar método lerEmail() no registrador <------------------------
            Registrador.lerString("\nInsira seu telefone: "), //Telefone ---------> Criar método lerTelefone() no registrador <-------------------
            Registrador.ler
        }
}
