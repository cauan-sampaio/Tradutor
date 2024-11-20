import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TradutorTest {
    private static Tradutor t;
    
    @BeforeEach
    public void criarTradutor(){
        t = new Tradutor();
    }
    @Test
    public void tradutorSemPalavras(){
        assertTrue(t.estaVazio());
    }
    @Test
    public void umaTraducao() {
        t.adicionaTraducao("bom", "good");
        assertFalse(t.estaVazio());
        assertEquals("good", t.traduzir("bom"));
    }
    @Test
    public void duasTraducao(){
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("mal", "bad"); 
        assertFalse(t.estaVazio());
        assertEquals("bad", t.traduzir("mal"));
    } 
    @Test
    public void duasTraducaoMesmaPalavra(){
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("bom", "nice");
        assertFalse(t.estaVazio());
        assertEquals("good, nice", t.traduzir("bom"));
    }
    @Test
    public void traduzirFrase(){
        t.adicionaTraducao("guerra", "war"); 
        t.adicionaTraducao("é", "is");
        t.adicionaTraducao("ruim", "bad");
        assertFalse(t.estaVazio());
        assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
    }
    @Test
    public void traduzirFraseComDuasTraducoesMesmaPalavra(){
        t.adicionaTraducao("paz", "peace");
        t.adicionaTraducao("é", "is");
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("bom", "nice");
        assertFalse(t.estaVazio());
        assertEquals("peace is good", t.traduzirFrase("paz é bom"));
    }
}