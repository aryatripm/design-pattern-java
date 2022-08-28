// Nama Program: Prototype Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class PrototypePattern {
    public static void main(String[] args) {
        // Create first object
        PrototypeDemo object1 = new PrototypeDemo("Object 1");

        // Clone first object
        PrototypeDemo object2 = object1.clone();
    }
}


class PrototypeDemo {

    String name;

    PrototypeDemo(String name) {
        this.name = name;
    }

    public PrototypeDemo clone() {
        return new PrototypeDemo(this.name);
    }
}