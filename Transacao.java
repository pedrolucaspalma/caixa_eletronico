import java.util.Calendar;

public class Transacao implements TransacaoEmConta{
    private String remetente;
    private String descricao;
    private String tipoOperacao;
    private String destinatário;
    private float valor;
    private Calendar data;
    
    public String getRemetente() {
        return remetente;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getTipoOperacao() {
        return tipoOperacao;
    }
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
    public String getDestinatário() {
        return destinatário;
    }
    public void setDestinatário(String destinatário) {
        this.destinatário = destinatário;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }

}