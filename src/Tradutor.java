import java.util.HashMap;
import java.util.Map;

public class Tradutor {
    private Map<String,String> traducoes = new HashMap<>();
    public boolean estaVazio() {
        return traducoes.isEmpty();
    }

    public String traduzir(String palavra) {
        return traducoes.get(palavra);
    }

    public void adicionaTraducao(String palavra, String traducao) {
        if(traducoes.containsKey(palavra)) {
                traducao = traduzir(palavra)+", " +traducao;
        }
        traducoes.put(palavra, traducao);
    }

    public String traduzirFrase(String frase) {
        String[] palavras = frase.split(" ");
        String fraseTraduzida = "";
        for (String palavra : palavras) {
             String traducao = traduzir(palavra);
             if (traducao.contains(",")) {
                traducao = traducao.substring(0,traducao.indexOf(","));
             }
             fraseTraduzida += " " +traducao;
        }
        return fraseTraduzida.trim();
    }
}
