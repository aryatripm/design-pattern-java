// Nama Program: State Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah

public class StatePattern {
    public static void main(String[] args) {
        Application myApplication = new Application();
        myApplication.changeMode(new LightMode());
        System.out.println("Application mode : " + myApplication.modeState);

        myApplication.changeMode(new DarkMode());
        System.out.println("Application mode : " + myApplication.modeState);
    }
}

class Application {
    Mode modeState;

    void changeMode(Mode mode) {
        modeState = mode;
        modeState.change();
    }
}

interface Mode {
    void change();
}

class LightMode implements Mode {
    @Override
    public void change() {
        System.out.println("Set to light mode");
    }
}

class DarkMode implements Mode {
    @Override
    public void change() {
        System.out.println("Set to dark mode");
    }
}