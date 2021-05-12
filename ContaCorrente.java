public class ContaCorrente extends Conta {
    public ContaCorrente (String cpf, String dataDeNascimento, String email, String telefone, String senha, String agencia, String numeroDaConta) {
        //Limite de cheque especial R$3000,00 (É um atributo da Conta Corrente ou não?)
        super(cpf, dataDeNascimento, email, telefone, senha, agencia, numeroDaConta);
    }
}
