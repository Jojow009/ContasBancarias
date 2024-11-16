package Tools;
import java.util.regex.Pattern;

public class Validacoes {

    public static boolean EhTelefoneValido(String Telefone) {
        final String DDDsValidos = "11-12-13-14-15-16-17-18-19-" +
                "21-22-24-27-28-31-32-33-34-" +
                "35-37-38-41-42-43-44-45-46-" +
                "47-48-49-51-53-54-55-61-62-" +
                "63-64-65-66-67-68-69-71-73-" +
                "74-75-77-79-81-82-83-84-85-" +
                "86-87-88-89-91-92-93-94-95-" +
                "96-97-98-99";
        String Aux = Telefone.replaceAll("[^0-9]", "");

        if ((Aux.length() != 10) && (Aux.length() != 11))
            return false;

        if (!DDDsValidos.contains(Aux.substring(0, 2)))
            return false;

        if (((Aux.length() == 11) && ("12345".contains(Aux.substring(2, 3)))) ||
                ((Aux.length() == 10) && ("16789".contains(Aux.substring(2, 3)))))
            return false;

        if ("0000".equals(Aux.substring(Aux.length() - 4, Aux.length())))
            return false;

        return true;
    }

    public static boolean EhCPFValido(String CPF) {
        String Aux = CPF.replaceAll("[^0-9]", "");
        char DV;
        int Soma, Resto;

        if (Aux.length() != 11)
            return false;

        if ((Aux.equals("00000000000")) || (Aux.equals("11111111111")) ||
                (Aux.equals("22222222222")) || (Aux.equals("33333333333")) ||
                (Aux.equals("44444444444")) || (Aux.equals("55555555555")) ||
                (Aux.equals("66666666666")) || (Aux.equals("77777777777")) ||
                (Aux.equals("88888888888")) || (Aux.equals("99999999999")))
            return false;

        Soma = 0;
        for (int i = 0; i < 9; i++)
            Soma += ((Aux.charAt(i) - 48) * (10 - i));

        Resto = 11 - (Soma % 11);
        if (Resto >= 10)
            DV = '0';
        else
            DV = (char) (Resto + 48);

        if (Aux.charAt(9) != DV)
            return false;

        Soma = 0;
        for (int i = 0; i < 10; i++)
            Soma += ((Aux.charAt(i) - 48) * (11 - i));

        Resto = 11 - (Soma % 11);
        if (Resto >= 10)
            DV = '0';
        else
            DV = (char) (Resto + 48);

        if (Aux.charAt(10) != DV)
            return false;

        return true;
    }

    public static boolean EhCNPJValido(String CNPJ) {
        String Aux = CNPJ.replaceAll("[^0-9]", "");
        char DV;
        int Soma, Multiplicador, Resto;

        if (Aux.length() != 14)
            return false;

        if ((Aux.equals("00000000000000")) || (Aux.equals("11111111111111")) ||
                (Aux.equals("22222222222222")) || (Aux.equals("33333333344433")) ||
                (Aux.equals("44444444444444")) || (Aux.equals("55555555555555")) ||
                (Aux.equals("66666666666666")) || (Aux.equals("77777777777777")) ||
                (Aux.equals("88888888888888")) || (Aux.equals("99999999999999")))
            return false;

        Soma = 0;
        Multiplicador = 2;
        for (int i = 11; i >= 0; i--) {
            Soma += ((Aux.charAt(i) - 48) * Multiplicador);

            if (++Multiplicador > 9)
                Multiplicador = 2;
        }

        Resto = 11 - (Soma % 11);
        if (Resto >= 10)
            DV = '0';
        else
            DV = (char) (Resto + 48);

        if (Aux.charAt(12) != DV)
            return false;

        Soma = 0;
        Multiplicador = 2;
        for (int i = 12; i >= 0; i--) {
            Soma += ((Aux.charAt(i) - 48) * Multiplicador);

            if (++Multiplicador > 9)
                Multiplicador = 2;
        }

        Resto = 11 - (Soma % 11);
        if (Resto >= 10)
            DV = '0';
        else
            DV = (char) (Resto + 48);

        if (Aux.charAt(13) != DV)
            return false;

        return true;
    }

    public static boolean EhEmailValido(String Email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        if (Email == null || Email.isEmpty()) {
            return false;
        }

        return pattern.matcher(Email).matches();
    }


}
