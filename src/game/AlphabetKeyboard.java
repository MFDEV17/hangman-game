package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlphabetKeyboard {

  private String alphabetKeyboard;
  private final Set<String> deletedLetters = new HashSet<>();

  public AlphabetKeyboard() {
    List<String> alphabet;

    try {
      alphabet = Files.readAllLines(Path.of("src/game/data/alphabet.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    StringBuilder keyboard = new StringBuilder();

    for (String s : alphabet) {
      keyboard.append(String.format("[%s]", s));
    }

    alphabetKeyboard = keyboard.toString();
  }

  public void deleteCharacterFromBoard(String toDelete) {
    alphabetKeyboard = alphabetKeyboard.replace(toDelete.charAt(0), ' ');
    deletedLetters.add(toDelete);
  }

  public String getAlphabetKeyboard() {
    return alphabetKeyboard;
  }

  public boolean containsInDeletedLetters(String letter) {
    return deletedLetters.contains(letter);
  }
}
