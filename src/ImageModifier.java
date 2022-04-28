import java.io.*;

public class ImageModifier {

    File file;

    public ImageModifier(File file) {
        this.file = file;
    }

    public String sacarNombreArxivo() {
        String[] nomobre = file.getName().split("\\.");
        return nomobre[0];
    }

    public void imagenModifierNegativo() throws IOException {

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("resources/" + sacarNombreArxivo() + "_negativa.bmp"));
        byte[] info = bin.readNBytes(54);
        bout.write(info);
        int bite = bin.read();
        while (bite != -1) {
            bout.write(255 - bite);
            bite = bin.read();
        }
        bin.close();
        bout.close();
    }


    public void imagenModifierOscura() throws IOException {

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("resources/" + sacarNombreArxivo() + "_oscura.bmp"));
        byte[] info = bin.readNBytes(54);
        bout.write(info);
        int bite = bin.read();
        while (bite != -1) {
            bout.write(bite / 2);
            bite = bin.read();
        }
        bin.close();
        bout.close();
    }

    public void imagenModifierNegro_Gris() throws IOException {

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("resources/" + sacarNombreArxivo() + "_blanco_negro.bmp"));
        byte[] info = bin.readNBytes(54);
        bout.write(info);
        int bite1 = bin.read();
        int bite2 = bin.read();
        int bite3 = bin.read();


        while (bite1 != -1) {
            int pixel = (bite1 + bite3 + bite2);
            if (pixel / 3 < 128) {
                pixel = 0;
            } else {
                pixel = 255;
            }
            bout.write(pixel);
            bout.write(pixel);
            bout.write(pixel);

            bite1 = bin.read();
            bite2 = bin.read();
            bite3 = bin.read();
        }
        bin.close();
        bout.close();

    }

}
