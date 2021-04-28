public class ContaCorrente extends Conta {
    //Limite de cheque especial R$3000,00 (É um atributo da Conta Corrente ou não?)

    public ContaCorrente(String cpf, String dataDeNascimento, String email, String telefone, String senha, String agencia, String numeroDaConta){
        super(cpf, dataDeNascimento, email, telefone, senha, agencia, numeroDaConta);
    }
}
