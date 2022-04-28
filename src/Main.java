import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("resources/penyagolosa.bmp");

        ImageModifier modifier = new ImageModifier(file);

        modifier.imagenModifierNegativo();
        modifier.imagenModifierOscura();
        modifier.imagenModifierNegro_Gris();
    }
}
