// Nama Program: Strategy Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

import java.time.LocalTime;

class Main {
    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        LocalTime now = LocalTime.now();

        if (now.isBefore(LocalTime.NOON) && now.isAfter(LocalTime.MIDNIGHT)) {

            Morning morning = new Morning();
            greeting.setSayHello(morning);

        } else if (now.isAfter(LocalTime.NOON) && now.isBefore(LocalTime.parse( "18:00:00" ))) {

            Afternoon afternoon = new Afternoon();
            greeting.setSayHello(afternoon);

        } else {

            Evening evening = new Evening();
            greeting.setSayHello(evening);

        }

        greeting.greet();
    }
}

class Greeting {
    public SayHello sayHello;

    public void setSayHello(SayHello sayHello) {
        this.sayHello = sayHello;
    }

    public void greet() {
        System.out.println(sayHello.sayHello());
    }
}

interface SayHello {
    String sayHello();
}

class Morning implements SayHello {

    @Override
    public String sayHello() {
        return "Good Morning";
    }
}

class Afternoon implements SayHello {

    @Override
    public String sayHello() {
        return "Good Afternoon";
    }
}

class Evening implements SayHello {

    @Override
    public String sayHello() {
        return "Good Evening";
    }
}