public class DadosPessoais {
    private String cpf;
    private String dataDeNascimento;
    private String email;
    private String telefone;

    public DadosPessoais(String cpf, String dataDeNascimento, String email, String telefone) {
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
}
