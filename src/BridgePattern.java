// Nama Program: Bridge Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class BridgePattern {
    public static void main(String[] args) {
        CharacterA characterA = new CharacterA();
        CharacterB characterB = new CharacterB();

        characterA.setWeapon(new WeaponA());
        characterB.setWeapon(new WeaponB());

        characterA.setWeapon(new WeaponB());
        characterB.setWeapon(new WeaponA());

    }
}

interface Character {
    void setWeapon(Weapon weapon);
}

interface Weapon {}

class CharacterA implements Character {

    private Weapon weapon;

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

class CharacterB implements Character {

    private Weapon weapon;

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

class WeaponA implements Weapon {}

class WeaponB implements Weapon {}