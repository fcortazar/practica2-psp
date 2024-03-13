package Ej2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class counter {
    public static void main(String[] args) {
        String operacion = "dividir";
        double num1 = 12;
        double num2 = 6;
        String rutaArchivo = "resultado.txt";

        double resultado = realizarOperaciones(operacion, num1, num2);
        guardarResultado(rutaArchivo, resultado);

        invocarProceso();
    }

    public static double realizarOperaciones(String operacion, double num1, double num2) {
        double resultado = 0;
        switch (operacion) {
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                resultado = num1 / num2;
                break;
            default:
                System.out.println("Operación no válida");
        }
        return resultado;
    }

    public static void guardarResultado(String rutaArchivo, double resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(Double.toString(resultado));
            System.out.println("El resultado se ha guardado en " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el resultado: " + e.getMessage());
        }
    }

    public static void invocarProceso() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al invocar el proceso: " + e.getMessage());
        }
    }
}