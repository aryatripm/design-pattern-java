// Nama Program: Chain of Responsibility Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Bermain bermain = new Bermain();
        Belajar belajar = new Belajar();

        bermain.setNext(belajar);

        bermain.lakukan();
    }
}

// Handler
interface Kegiatan {
    void setNext(Kegiatan nextKegiatan);
    void lakukan();
}

// Base Handler
class BaseKegiatan implements Kegiatan {
    private Kegiatan nextKegiatan;

    @Override
    public void setNext(Kegiatan nextKegiatan) {
        this.nextKegiatan = nextKegiatan;
    }

    @Override
    public void lakukan() {
        if (nextKegiatan != null) {
            System.out.println("Melakukan kegiatan selanjutnya :");
            nextKegiatan.lakukan();
        }
    }
}

// Concrete Handler
class Belajar extends BaseKegiatan {
    @Override
    public void lakukan() {
        System.out.println("Sedang belajar");
        super.lakukan();
    }
}

// Concrete Handler
class Bermain extends BaseKegiatan {
    @Override
    public void lakukan() {
        System.out.println("Sedang bermain");
        super.lakukan();
    }
}