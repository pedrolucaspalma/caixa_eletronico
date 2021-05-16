import java.time.LocalDate;

public interface TransacaoEmConta {
    float getValor();
    String getDescricao();
    String getTipoOperacao();
    LocalDate getData();
}