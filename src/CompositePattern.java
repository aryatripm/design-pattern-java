// Nama Program: Composite Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Kotak kotak = new Kotak();

        Kotak kotak2 = new Kotak();
        kotak2.add(new Laptop());

        kotak.add(new Handphone());
        kotak.add(new Laptop());
        kotak.add(kotak2);

        System.out.println(kotak.harga());
    }
}

interface Barang {
    int harga();
}

class Kotak implements Barang {

    private final List<Barang> isiKotak = new ArrayList<>();

    @Override
    public int harga() {
        int result = 0;
        for (Barang b: isiKotak) {
            result += b.harga();
        }
        return result;
    }

    public void add(Barang barang) {
        isiKotak.add(barang);
    }

    public void remove(Barang barang) {
        isiKotak.remove(barang);
    }

    public List<Barang> getIsiKotak() {
        return isiKotak;
    }
}

class Handphone implements Barang {
    @Override
    public int harga() {
        return 1000;
    }
}

class Laptop implements Barang {
    @Override
    public int harga() {
        return 3000;
    }
}
