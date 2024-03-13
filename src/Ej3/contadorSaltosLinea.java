package Ej3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class contadorSaltosLinea {
    public static void main(String[] args) {
        String archivoEntrada = args[0]; // Ruta del archivo de entrada
        String archivoResultado = args[1]; // Ruta del archivo donde se guardará el resultado

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
            FileWriter writer = new FileWriter(archivoResultado);

            int saltosLinea = 0;
            String linea = reader.readLine();
            while (linea != null) {
                saltosLinea++;
                linea = reader.readLine();
            }

            writer.write("El archivo " + archivoEntrada + " tiene " + saltosLinea + " saltos de línea.");
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}