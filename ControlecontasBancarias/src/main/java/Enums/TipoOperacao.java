package Enums;

public enum TipoOperacao
{
    toDiminuirSaldo('-'),
    toAumentarSaldo('+'),
    toNaoAlteraSaldo('=');
    private char ValorEnum;

    TipoOperacao(char ValorEnum)
    {


    }

    public char getValorEnum()
    {
        return ValorEnum;
    }

}

