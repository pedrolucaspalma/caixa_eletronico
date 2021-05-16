import java.time.LocalDate;
import java.time.Period;

public class ContaPoupanca extends Conta {
    public ContaPoupanca (
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
        super(nome, cpf, dataDeNascimento, email, telefone, senha, numeroDaConta, dataDeCriacao,saldo);
    }

    public void atualizarRendimento(LocalDate antigaData, LocalDate novaData) {
        Period periodoDataCriacaoDataAntiga = Period.between(dataDeCriacao, antigaData);
        Period periodoDataCriacaoDataNova = Period.between(dataDeCriacao, novaData);
        Period periodoRendimento = periodoDataCriacaoDataNova.minus(periodoDataCriacaoDataAntiga);
        int meses = periodoRendimento.getMonths();

        saldo = (float)(Math.pow(saldo * (1 + 0.03), meses));
    }
}