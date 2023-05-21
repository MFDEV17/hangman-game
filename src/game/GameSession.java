package game;

import java.io.IOException;
import java.util.Scanner;

import static game.Util.*;
import static game.Util.deleteFirstAndLastFromKeyboard;

public class GameSession {
  private final AlphabetKeyboard keyboard = new AlphabetKeyboard();
  private final String realWord;
  private String encodedWord;

  private int tries = 0;

  public GameSession() throws IOException {
    realWord = Words.getRandomWord();
    encodedWord = encodeWord(realWord);
  }

  public void startGameSession() {
    Scanner scan = new Scanner(System.in);
    deleteFirstAndLastFromKeyboard(keyboard, encodedWord);

    while (!realWord.equals(encodedWord)) {

      if (tries == 8) {
        System.out.print(HangmanView.STATE_9.getView());
        System.out.printf("Вы проиграли :(\n\t\t  Загаданное слово: %s\n", realWord);
        break;
      }

      System.out.print(HangmanView.valueOf(tries));
      System.out.printf("\t\t%s\n\n", encodedWord);
      System.out.print(keyboard.getAlphabetKeyboard());
      System.out.print("\n\nВведите букву: ");

      String input = scan.nextLine();

      if (input.length() != 1) {
        System.out.println("Некорректный ввод");
        continue;
      }

      if (keyboard.containsInDeletedLetters(input)) {
        System.out.println("Буква уже была введена раннее");
        continue;
      }

      if (isValidLetter(input)) {
        if (letterContainsInWord(realWord, input)) {
          encodedWord = replaceHideToLetter(encodedWord, realWord, input);
        } else {
          tries++;
        }
        keyboard.deleteCharacterFromBoard(input);
      } else {
        System.out.println("Некорректная буква\n\n");
      }
    }

    if (tries < 8) {
      System.out.printf("Вы победили!\nЗагаданное слово: %s\n", realWord);
    }
  }
}
