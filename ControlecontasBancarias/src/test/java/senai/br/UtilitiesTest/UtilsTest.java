package senai.br.UtilitiesTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UtilsTest
{
    private Utils utils;

    @Test
    void testfillDireita()
    {
        String retornoChamada = utils.Fill("abc", '*', FillSide.fsDireita, 5); 
        assertEquals(retornoChamada, "abc**");
    }
    @Test
    void testfillEsquerda()
    {
        String retornoChamada = utils.Fill("abc", '*', FillSide.fsEsquerda, 5);
        assertEquals(retornoChamada, "**abc");
    }
}
