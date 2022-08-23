// Nama Program: Mediator Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class MediatorPattern {
    public static void main(String[] args) {

        User andi = new User("andi");
        User budi = new User("budi");

        // Mengirim pesan melalui mediator
        andi.sendMsg(budi, "Hi budi");
    }
}

// Mediator
class Chat {
    static void send(User from, User to, String msg) {
        System.out.println(from.name + " kepada " + to.name + ", dengan pesan : " + msg);
    }
}

class User {
    String name;

    User(String name) {
        this.name = name;
    }

    void sendMsg(User user, String message) {
        Chat.send(this,user, message);
    }
}