import java.util.ArrayList;

public class Caixa{
    private ArrayList<ContaCorrente> listaDeContasCorrentes = new ArrayList<ContaCorrente>();
    private ArrayList<ContaPoupanca> listaDeContasPoupancas = new ArrayList<ContaPoupanca>();

    // public string gerarNumeroConta(){
        //Método que soma o tamanho dos dois arraylists de conta corrente e conta poupança
    // }

    public boolean verificarSeHaContaCorrentePorCpf(String cpf){
        for (ContaCorrente conta : listaDeContasCorrentes){
            if(conta.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarSeHaContaPoupancaPorCpf(String cpf){
        for (ContaCorrente conta : listaDeContasPoupancas){
            if(conta.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public void criarContaCorrente(){
        String cpf;

        cpf = Registrador.lerString("Insira seu cpf: "); //CPF

        if(verificarSeHaContaCorrentePorCpf(cpf) == true){
            System.out.println("Erro! O CPF inserido já possui uma conta corrente.");
        }
        
/*          if(verificarSeHaContaPoupancaPorCpf( == true){
                criar conta corrente baseado nos dados da conta poupança
        }) 
*/
 


        ContaCorrente conta = new ContaCorrente(
            cpf,
            Registrador.lerData("\nInsira sua data de Nascimento: "), //Data de nascimento
            Registrador.lerString("\nInsira seu email: "), //Email -------> Criar método lerEmail() no registrador <------------------------
            Registrador.lerString("\nInsira seu telefone: "), //Telefone ---------> Criar método lerTelefone() no registrador <-------------------
            Registrador.lerString("\nInsira sua senha: "), //Senha
            "001" //Agência sempre é uma string 001
            //gerarNumeroConta()
            );
        listaDeContasCorrentes.add(conta);
        }
}
