public interface BancoDeUsuarios {
    public void cadastrarUsuario();
    public void listarDadosDoUsuario(Usuario usuario);
    public Usuario procurarUsuario(String senha);
}
