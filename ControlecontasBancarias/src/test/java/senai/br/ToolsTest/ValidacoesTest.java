package senai.br.ToolsTest;
import Tools.Validacoes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ValidacoesTest
{
    private Validacoes tools;

    private 
    @Test
    void testEhCPFValido()
    {
        boolean retornoChamada = tools.EhCPFValido("832.592.870-00");
        assertEquals(retornoChamada, true);
    }
}
