import java.time.LocalDate;

public class Transacao implements TransacaoEmConta {
    private String remetente;
    private String descricao;
    private String tipoOperacao;
    private String destinatario;
    private LocalDate data;
    private float valor;

    public Transacao(String remetente, String descricao, String tipoOperacao, String destinatario, float valor, LocalDate data) {
        this.remetente = remetente;
        this.descricao = descricao;
        this.tipoOperacao = tipoOperacao;
        this.destinatario = destinatario;
        this.valor = valor;
        this.data = data;
    }

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
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatário) {
        this.destinatario = destinatário;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

}
