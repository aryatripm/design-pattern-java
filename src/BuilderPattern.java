// Nama Program: Builder Pattern
// Nama/NRP: 2072023/Arya Tri Putra Majiah
// Nama/NRP Partner: Martin Widarmadi/2072010

public class BuilderPattern {
    public static void main(String[] args) {
        CharacterBuilder builder = new CharacterBuilder();
        GameMaster gameMaster = new GameMaster(builder);

        //  Make Player Character
        gameMaster.make("player");
        Character player = builder.getResult();
        builder.reset();

        // Mkae NPC
        Character npc = builder.getResult();
    }
}

// Builder
class CharacterBuilder {
    private Character result;

    public void reset() {
        result = new Character();
    }

    public void hasWeapon() { this.result.setWeapon(new Weapon()); }
    public void hasShield() { this.result.setShield(new Shield()); }
    public void hasArmor() { this.result.setArmor(new Armor());}

    public Character getResult() { return this.result; }
}

// Director
class GameMaster {
    private final CharacterBuilder builder;

    GameMaster(CharacterBuilder builder) {
        this.builder = builder;
    }

    public void make(String type) {
        if (type == "player") {
            builder.hasWeapon();
            builder.hasShield();
            builder.hasArmor();
        } else  {
            // NPC
            builder.hasArmor();
        }
    }
}

class Character {
    private Weapon weapon;
    private Shield shield;
    private Armor armor;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

class Weapon {}
class Shield{}
class Armor {}