package game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Words {
  public static String getRandomWord(File words) throws IOException {
    List<String> wordsList = Files.readAllLines(words.toPath())
            .stream()
            .filter(word -> word.length() > 5).toList();

    Random rand = new Random();
    return wordsList.get(rand.nextInt(wordsList.size())).toLowerCase();
  }

  public static String getRandomWord() throws IOException {
    List<String> words = Files.readAllLines(Path.of("src/game/data/words.txt"))
            .stream()
            .filter(word->word.length() > 5).toList();

    Random rand = new Random();
    return words.get(rand.nextInt(words.size())).toLowerCase();
  }
}
