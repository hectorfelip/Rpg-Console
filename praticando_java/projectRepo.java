import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class projectRepo {

    private final String filePath = "dataJogador.json"; // where the JSON file lives
    private final Gson gson = new Gson(); // tool that converts Java <-> JSON

    // Step 3: save a list of tasks into the JSON file
    public void save(List<JogadorUse> jogador) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(jogador, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Step 4: load the list of tasks from the JSON file
    public List<JogadorUse> load() {
        try (FileReader reader = new FileReader(filePath)) {
            Type jogadorListType = new TypeToken<
                List<JogadorUse>
            >() {}.getType();
            List<JogadorUse> jogadorInfo = gson.fromJson(
                reader,
                jogadorListType
            );
            return jogadorInfo != null ? jogadorInfo : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("No existing data found, starting fresh.");
            return new ArrayList<>();
        }
    }
}
