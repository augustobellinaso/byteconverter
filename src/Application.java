import javax.swing.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        String numero = JOptionPane.showInputDialog(null, "Digite a quantidade de bytes para converter: ");
        JOptionPane.showMessageDialog(null, converterBytes(new BigDecimal(numero)), "Resultado",JOptionPane.INFORMATION_MESSAGE);


    }

    public static String converterBytes(BigDecimal bytes) {

        DecimalFormat df = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.ENGLISH));
        double bytesDouble = bytes.doubleValue();
        String[] prefixos = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int contador = 0;

        try {

            if (bytesDouble < 1024) {
                return "Para o número " + bytes + " temos como resultado '" + df.format(bytes) + " " + prefixos[contador] + "'";
            }

            while ((bytesDouble / 1024) >= 1) {
                bytesDouble /= 1024;
                contador++;
            }

            return "Para o número " + bytes + " temos como resultado '" + df.format(bytesDouble) + " " + prefixos[contador] + "'";

        } catch (ArrayIndexOutOfBoundsException e) {
            return "Para o número " + bytes + " não temos prefixo definido ainda.";
        }
    }
}
