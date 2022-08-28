// Nama Program: Command Pattern
// Nama/NRP: Martin Widarmadi/2072010
// Nama/NRP Partner: Arya Tri Putra Majiah/2072023

function add(x, y) {
  return x + y;
}
function sub(x, y) {
  return x - y;
}
function mul(x, y) {
  return x * y;
}
function div(x, y) {
  return x / y;
}

class Command {
  constructor(execute, undo, value) {
    this.execute = execute;
    this.undo = undo;
    this.value = value;
  }
}

class AddCommand {
  constructor(value) {
    return new Command(add, sub, value);
  }
}

class SubCommand {
  constructor(value) {
    return new Command(sub, add, value);
  }
}

class MulCommand {
  constructor(value) {
    return new Command(mul, div, value);
  }
}

class DivCommand {
  constructor(value) {
    return new Command(div, mul, value);
  }
}

class Calculator {
  constructor() {
    this.current = 0;
    this.commands = [];
  }

  action(command) {
    let name = command.execute.toString().substr(9, 3);
    return name.charAt(0).toUpperCase() + name.slice(1);
  }

  execute(command) {
    this.current = command.execute(this.current, command.value);
    this.commands.push(command);
    console.log(`${this.action(command)}: ${command.value}`);
  }

  undo() {
    let command = this.commands.pop();
    this.current = command.undo(this.current, command.value);
    console.log(`Undo ${this.action(command)}: ${command.value}`);
  }

  getCurrentValue() {
    return this.current;
  }
}

const calculator = new Calculator();

// issue commands

calculator.execute(new AddCommand(100));
calculator.execute(new SubCommand(24));
calculator.execute(new MulCommand(6));
calculator.execute(new DivCommand(2));

// reverse last two commands

calculator.undo();
calculator.undo();
calculator.undo();

console.log('\nValue: ' + calculator.getCurrentValue());