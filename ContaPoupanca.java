import java.util.Calendar;

public class ContaPoupanca extends Conta {
    public ContaPoupanca (String nome, String cpf, Calendar dataDeNascimento, String email, String telefone, String senha, String numeroDaConta, float saldo) {
        super(nome, cpf, dataDeNascimento, email, telefone, senha, numeroDaConta, saldo);
    }
}
