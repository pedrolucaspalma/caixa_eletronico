public class Caixa{
    private int numeroDeContas;

    // public string gerarNumeroConta(){
        //Método que incrementa uma variável contadora em 1 a cada nova conta criada e faz uma string com 4 algarismos(apenas ideia). Por exemplo, caso seja a 56ª conta a ser criada, gera o inteiro 56, coloca ele como string 0056 e retorna essa string
    // }

    public void criarContaCorrente(){
        ContaCorrente conta = new ContaCorrente(
            Registrador.lerString("Insira seu cpf: "), //CPF
            Registrador.lerData("\nInsira sua data de Nascimento: "), //Data de nascimento
            Registrador.lerString("\nInsira seu email: "), //Email -------> Criar método lerEmail() no registrador <------------------------
            Registrador.lerString("\nInsira seu telefone: "), //Telefone ---------> Criar método lerTelefone() no registrador <-------------------
            Registrador.lerString("\nInsira sua senha: "), //Senha
            "001", //Agência sempre é uma string 001
            //gerarNumeroConta()
        )
        }
}
