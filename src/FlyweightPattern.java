// Nama Program: Flyweight Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class FlyweightPattern {
    public static void main(String[] args) {
        Enemy enemy1 = new Enemy();

        Bullet bullet1 = new Bullet();
        Bullet bullet2 = new Bullet();

        BulletSprite sprite = new BulletSprite("contoh.jpg");

        // Setiap bullet memakai sprite(gambar) yang sama
        // Jadi setiap bullet tidak memiliki sprite sendiri
        bullet1.setSprite(sprite);
        bullet2.setSprite(sprite);

        enemy1.bullets = new Bullet[2];
        enemy1.bullets[0] = bullet1;
        enemy1.bullets[1] = bullet2;
    }
}

class Enemy {
    public Bullet[] bullets;
    public BulletSprite[] sprites;

    public void fire() {}
}

class Bullet {
    private BulletSprite sprite;

    public void setSprite(BulletSprite sprite) {
        this.sprite = sprite;
    }
}

// BulletSprite
class BulletSprite{
    private String asset_location;

    BulletSprite(String asset_location) {
        this.asset_location = asset_location;
    }

    public String getSprite() {
        return asset_location;
    }

    public void setSprite(String asset_location) {
        this.asset_location = asset_location;
    }
}
