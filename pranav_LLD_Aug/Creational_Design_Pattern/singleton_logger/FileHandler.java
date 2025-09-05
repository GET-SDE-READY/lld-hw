import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler implements ILogHandler{

    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String message) {

        try(PrintWriter out = new PrintWriter(new FileWriter(filePath,true))) {

            out.println(message);

        } catch (IOException e) {
            System.err.println("Logger FileHandler error: " + e.getMessage());
        }
    }
}
