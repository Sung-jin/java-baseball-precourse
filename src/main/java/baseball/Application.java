package baseball;

import baseball.play.domain.Play;

public class Application {
    public static void main(String[] args) {
        Play play = new Play();
        play.start();
    }
}
