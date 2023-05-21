package game;

import static java.util.stream.IntStream.range;

public class Util {

  public static String encodeWord(String word) {
    StringBuilder encoded = new StringBuilder(word);

    char atStart = encoded.charAt(0);
    char atEnd = encoded.charAt(encoded.length() - 1);

    for (int i = 1; i < word.length() - 1; i++) {
      if (encoded.charAt(i) == atStart || encoded.charAt(i) == atEnd) {
        continue;
      }
      encoded.setCharAt(i, '_');
    }
    return encoded.toString();
  }

  public static String replaceHideToLetter(String hideWord, String originalWord, String letter) {
    StringBuilder builder = new StringBuilder(hideWord);

    range(1, originalWord.length()).forEach(index -> {
      char ch = letter.charAt(0);
      if (originalWord.charAt(index) == ch) builder.setCharAt(index, ch);
    });

    return builder.toString();
  }

  public static boolean letterContainsInWord(String word, String letter) {
    return word.contains(letter);
  }

  public static boolean isValidLetter(String letter) {
    char ch = letter.charAt(0);
    return ch >= 1072 && ch <= 1103;
  }

  public static void deleteFirstAndLastFromKeyboard(AlphabetKeyboard keyboard, String word) {
    keyboard.deleteCharacterFromBoard(Character.toString(word.charAt(0)));
    keyboard.deleteCharacterFromBoard(Character.toString(word.charAt(word.length() - 1)));
  }
}
