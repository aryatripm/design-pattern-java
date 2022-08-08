// Nama Program: Factory Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class FactoryPattern {
    public static void main(String[] args) {
        FootballExercise footballCreator = new FootballExercise();
        BasketballExercise basketballCreator = new BasketballExercise();

        Football footballPractice = footballCreator.prepare();
        Basketball basketballPractice = basketballCreator.prepare();

        footballPractice.play();
        basketballPractice.play();
    }
}

// Product
interface Sport {
    void play();
}

// ConcreteProduct
class Football implements Sport {
    @Override
    public void play() {
        System.out.println("Playing football");
    }
}

// ConcreteProduct
class Basketball implements Sport {
    @Override
    public void play() {
        System.out.println("Playing basketball");
    }
}

// Creator (SportCreator)
abstract class Exercise {
    void warmingUp() {
        System.out.println("Warming Up!");
    }

    abstract Sport prepare();
}

class FootballExercise extends Exercise {
    @Override
    Football prepare() {
        return new Football();
    }
}

class BasketballExercise extends Exercise {
    @Override
    Basketball prepare() {
        return new Basketball();
    }
}