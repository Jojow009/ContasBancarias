package senai.br.ToolsTest;

import Tools.Validacoes;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteCnpj {
    @Nested
    class ValidaCNPJTest {

        @Test
        void testIsCNPJ() {
            // Testes com CNPJs válidos
            assertTrue(Validacoes.ValidaCNPJ.isCNPJ("12.345.678/0001-95"));
            assertTrue(Validacoes.ValidaCNPJ.isCNPJ("11.222.333/0001-81"));

            // Testes com CNPJs inválidos
            assertFalse(Validacoes.ValidaCNPJ.isCNPJ("00.000.000/0000-00"));
            assertFalse(Validacoes.ValidaCNPJ.isCNPJ("11.111.111/1111-11"));
            assertFalse(Validacoes.ValidaCNPJ.isCNPJ("12.345.678/0001-00"));
        }
    }
}
