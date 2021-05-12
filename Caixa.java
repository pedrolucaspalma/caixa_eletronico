import java.util.ArrayList;

public class Caixa{
    private ArrayList<ContaCorrente> listaDeContasCorrentes = new ArrayList<ContaCorrente>();
    private ArrayList<ContaPoupanca> listaDeContasPoupancas = new ArrayList<ContaPoupanca>();
    private Registrador input = new Registrador();

    // public string gerarNumeroConta(){
        //Método que soma o tamanho dos dois arraylists de conta corrente e conta poupança
    // }

    public boolean verificarSeHaContaCorrentePorCpf(String cpf){
        for (ContaCorrente conta : listaDeContasCorrentes){
            if (conta.getCpf().equals(cpf)){
                return true;
            }
        }

        return false;
    }

    public boolean verificarSeHaContaPoupancaPorCpf(String cpf){
        for (ContaPoupanca conta : listaDeContasPoupancas){
            if(conta.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public void criarContaCorrente(){
        String cpf = input.lerString("Insira seu cpf: "); //CPF

        if(verificarSeHaContaCorrentePorCpf(cpf) == true){
            System.out.println("Erro! O CPF inserido já possui uma conta corrente.");
            return;
        }
        
/*          if(verificarSeHaContaPoupancaPorCpf( == true){
                criar conta corrente baseado nos dados da conta poupança
        }) 
*/

         ContaCorrente conta = new ContaCorrente(
            cpf,
            input.lerData("\nInsira sua data de Nascimento: "), //Data de nascimento
            input.lerString("\nInsira seu email: "), //Email -------> Criar método lerEmail() no registrador <------------------------
            input.lerString("\nInsira seu telefone: "), //Telefone ---------> Criar método lerTelefone() no registrador <-------------------
            input.lerString("\nInsira sua senha: "), //Senha
            "001" //Agência sempre é uma string 001
            //gerarNumeroConta()
            );
        listaDeContasCorrentes.add(conta);
        } 
    }
}
