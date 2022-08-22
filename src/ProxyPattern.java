// Nama Program: Proxy Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah

public class ProxyPattern {
    public static void main(String[] args) {
        Connection connection = new ProxyConnection();
        // Percobaan pertama membuat koneksi
        connection.connect();

        // Percobaan kedua memakai koneksi yang sama
        connection.connect();
    }
}

interface Connection {
    void connect();
}

class DatabaseConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("Connecting...");
    }
}

class ProxyConnection implements Connection {

    private DatabaseConnection connection;

    @Override
    public void connect() {
        if (connection == null) {
            System.out.println("Creating connection...");
            connection = new DatabaseConnection();
        }
        connection.connect();
    }
}