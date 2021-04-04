package notatnik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class Notatka {

    public void nowa(String nazwa, String tekst, String adres) throws IOException {
        try {
            File file = new File(adres+nazwa+".txt");
            FileWriter fileWriter = new FileWriter(file, true);
            Formatter formatter = new Formatter(fileWriter);
            formatter.format("%s \r\n", tekst);

            fileWriter.close();
            formatter.close();
            System.out.println("Notatka utworzona");
        }
        catch (Exception e){
            System.out.println("Podano złą ścieżke docelową");
        }
    }
}