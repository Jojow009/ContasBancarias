package Utilities;

import static org.junit.jupiter.api.Assertions.*;

import Tools.Validacoes;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void testFillDireita(){
        String retornoChamada = Utils.Fill("abc", '*', FillSide.fsDireita, 5);
        assertEquals(retornoChamada, "abc**");
    }

    @Test
    void testFillEsquerda(){
        String retornoChamada = Utils.Fill("abc", '*', FillSide.fsESquerd, 5);
        assertEquals(retornoChamada, "**abc");
    }

    @Test
    void testCpf(){
        boolean retornoFuncao = Validacoes.EhCPFValido("12788666985");

        assertEquals(retornoFuncao, true);
    }

    @Test
    void testCNPJ(){
        boolean retornoFuncao = Validacoes.EhCNPJValido("15186435000140");

        assertEquals(retornoFuncao, true);
    }
    @Test
    void testTelefone(){
        boolean retornoFuncao = Validacoes.EhTelefoneValido("47988896490");

        assertEquals(retornoFuncao, true);
    }

    @Test
    void testEmail(){
        boolean retornoFuncao = Validacoes.EhEmailValido("lucas.nicoleli@hotmail.com");

        assertEquals(retornoFuncao, true);
    }

}