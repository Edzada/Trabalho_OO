package negocio;

import java.io.IOException;



public class Funcoes {

    public static void limparBuffer() {
        try {
            System.in.skip(System.in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void limparTela() {
        // Para sistemas operacionais Windows
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.out.print("\033[H\033[2J");
        }
        // Para sistemas operacionais Unix e macOS
        else {
            System.out.print("\033[H\033[2J");
        }
    }

    public static void aguardarComando() {
        try {
            System.out.println("Pressione ENTER para retornar ao menu...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

