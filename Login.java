public class Login {
    Registrador registrador = new Registrador();

    public void requisitarDados() {
        int numeroDaConta = registrador.lerInt("Digite o numero da conta do usuario");
        int senha         = registrador.lerInt("Digite a senha do usuario");
    }

    public Usuario fazerLogin() {
        requisitarDados();
    }
}
