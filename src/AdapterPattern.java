// Nama Program: Adapter Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class AdapterPattern {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(new PcGame());

        // Tanpa Adapter Error
        // player.play(new ConsoleGame());

        // Dengan Adapter
        Emulator emulator = new Emulator();
        emulator.consoleGame = new ConsoleGame();
        player.play(emulator);
    }
}

class Player{
    public void play(Game game) {
        game.play();
    }
}

interface Game {
    void play();
}

class PcGame implements Game{
    @Override
    public void play() {
        System.out.println("Playing pc games");
    }
}

// Adapter
class Emulator implements Game{
    public ConsoleGame consoleGame;

    @Override
    public void play() {
        consoleGame.playExclusiveGame();
    }
}

// Service
class ConsoleGame {
    public void playExclusiveGame() {
        System.out.println("Playing Exclusive Game");
    }
}