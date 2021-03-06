import java.time.LocalDate;

public class ContaCorrente extends Conta {
    public ContaCorrente (
                String nome,
                String cpf,
                LocalDate dataDeNascimento,
                String email,
                String telefone,
                String senha,
                String numeroDaConta,
                LocalDate dataDeCriacao,
                float saldo
    ) {
        super(nome, cpf, dataDeNascimento, email, telefone, senha, numeroDaConta, dataDeCriacao, saldo);
    }
}