package game;

public enum HangmanView {
  STATE_1("       |\n       |\n       |\n       |\n___    |  "),
  STATE_2("       |\n |     |\n |     |\n |     |\n_|_    |  "),
  STATE_3("  ____ |\n |     |\n |     |\n |     |\n_|_    |  "),
  STATE_4("  ____ |\n |   | |\n |   O |\n |     |\n_|_    |  "),
  STATE_5("  ____ |\n |   | |\n |   O |\n |   | |\n_|_    |  "),
  STATE_6("  ____ |\n |   | |\n |   O |\n |  /| |\n_|_    |  "),
  STATE_7("  ____ |\n |   | |\n |   O |\n |  /|\\|\n_|_    |  "),
  STATE_8("  ____ |\n |   | |\n |   O |\n |  /|\\|\n_|_ /  |  "),
  STATE_9("  ____ |\n |   | |\n |   O |\n |  /|\\|\n_|_ / \\|  ");

  private final String view;

  public String getView() {
    return view;
  }

  public static String valueOf(int state) {
    switch (state) {
      case 0 -> {
        return HangmanView.STATE_1.getView();
      }
      case 1 -> {
        return HangmanView.STATE_2.getView();
      }
      case 2 -> {
        return HangmanView.STATE_3.getView();
      }
      case 3 -> {
        return HangmanView.STATE_4.getView();
      }
      case 4 -> {
        return HangmanView.STATE_5.getView();
      }
      case 5 -> {
        return HangmanView.STATE_6.getView();
      }
      case 6 -> {
        return HangmanView.STATE_7.getView();
      }
      case 7 -> {
        return HangmanView.STATE_8.getView();
      }
      case 8 -> {
        return HangmanView.STATE_9.getView();
      }
      default -> {
        return null;
      }
    }
  }

  HangmanView(String view) {
    this.view = view;
  }
}
