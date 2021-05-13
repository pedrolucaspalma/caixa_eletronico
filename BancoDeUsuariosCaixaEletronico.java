import java.util.Map;
import java.util.HashMap;

public class BancoDeUsuariosCaixaEletronico implements BancoDeUsuarios {
    private Map<String/*Senha*/, Usuario> usuarios = new HashMap<String, Usuario>();

    public procurarUsuario(String senha){}
    public listarDadosDoUsuario(String senha){}
}
