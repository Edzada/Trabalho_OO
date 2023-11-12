package negocio;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsuarioFree extends Usuario {
    private byte[] imagem; // Variável para armazenar a imagem em formato de matriz de bytes

    public UsuarioFree(String n, String d, String nU, String e, String s) {
        super(n, d, nU, e, s);
        this.qtdNotas = 1500;
        this.qtdPastas = 50;
        this.pastas = new ArrayList<>(50);
        this.numPastas = 0;
    }

    public byte[] getImagem() {
        return imagem;
    }

    // Adicione um método para definir a imagem a partir de um caminho de arquivo
    public void setImagem(String imagePath) throws IOException {
        Path path = Path.of(imagePath);

        if (Files.exists(path)) {
            this.imagem = Files.readAllBytes(path);
        } else {
            throw new IOException("Arquivo de imagem não encontrado: " + imagePath);
        }
    }
}
