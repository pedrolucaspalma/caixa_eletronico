import java.util.Calendar;

public class ContaCorrente extends Conta {
    public ContaCorrente (String nome, String cpf, Calendar dataDeNascimento, String email, String telefone, String senha, String numeroDaConta, float saldo) {
        super(nome, cpf, dataDeNascimento, email, telefone, senha, numeroDaConta, saldo);
    }
}
