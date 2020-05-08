package app.estrategias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.interfaces.ComparacionVelocidadStrategy;

/**
 * Formato 1
 *  "Acceso VPN IP 1000M/1000M"
 */
public class Formato1Strategy implements ComparacionVelocidadStrategy {

    @Override
    public boolean compara(String velocidadRed1, String velocidadRed2) {

        String patron = "(\\d+)M\\/(\\d+)M";
        Pattern pattern = Pattern.compile(patron);

        Matcher matcher1 = pattern.matcher(velocidadRed1);
        Matcher matcher2 = pattern.matcher(velocidadRed2);

        if (!matcher1.find() || !matcher2.find()) {
            throw new IllegalArgumentException();
        }
            int velBajada1 = Integer.parseInt(matcher1.group(1));
            int velSubida1 = Integer.parseInt(matcher1.group(2));
            int velBajada2 = Integer.parseInt(matcher2.group(1));
            int velSubida2 = Integer.parseInt(matcher2.group(2));
      
        return velBajada1 > velBajada2 && velSubida1 > velSubida2;
    }

}