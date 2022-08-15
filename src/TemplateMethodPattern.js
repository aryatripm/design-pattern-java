// Nama Program: Template Method Pattern
// Nama/NRP: Martin Widarmadi/2072010
// Nama/NRP Partner: Arya Tri Putra Majiah/2072023
class Pokemon {
  constructor(name = 'unknown', power = 1, attack = 1, defense = 1) {
    this.name = name;
    this.power = power;
    this.attack = attack;
    this.defense = defense;
  }

  pokemonInfo() {
    return `${this.name}:\n
    Power: ${this.power}\n
    Attack: ${this.attack}\n
    Defense: ${this.defense}`;
  }

  calculateMultiplier() {
    return (1 / 2) * this.power * Math.random();
  }

  showDamage(damage) {
    console.log(`Pokemon damage is: ${damage}`);
  }

  calculateDamage() {
    const multipliers = this.calculateMultiplier();
    const damage = this.calculateImpact(multipliers);
    this.showDamage(damage);
  }
}

class FightingType extends Pokemon {
  constructor(name, power, attack, defense) {
    super(name, power, attack, defense);
  }

  calculateImpact(multipliers) {
    return Math.floor((this.attack / this.defense) * multipliers) + 1;
  }
}

class PoisonType extends Pokemon {
  constructor(name, power, attack, defense) {
    super(name, power, attack, defense);
  }

  calculateImpact(multipliers) {
    return Math.floor((this.attack - this.defense) * multipliers) + 1;
  }
}

class GroundType extends Pokemon {
  constructor(name, power, attack, defense) {
    super(name, power, attack, defense);
  }

  calculateImpact(multipliers) {
    return Math.floor((this.attack + this.defense) * multipliers) + 1;
  }
}

const mankey = new FightingType('Mankey', 10, 10, 10);
console.log(mankey.pokemonInfo());
mankey.calculateDamage();

const nidoking = new PoisonType('Nidoking', 100, 100, 20);
console.log(nidoking.pokemonInfo());
nidoking.calculateDamage();

const dugtrio = new GroundType('Dugtrio', 200, 150, 100);
console.log(dugtrio.pokemonInfo());
dugtrio.calculateDamage();
