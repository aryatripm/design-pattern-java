// Nama Program: Iterator Pattern
// Nama/NRP: Martin Widarmadi/2072010
// Nama/NRP Partner: Arya Tri Putra Majiah/2072023
class IteratorPattern {
  constructor(items) {
    this.index = 0;
    this.items = items;
  }

  first() {
    this.reset();
    return this.next();
  }

  next() {
    return this.items[this.index++];
  }

  hasNext() {
    return this.index <= this.items.length;
  }

  reset() {
    this.index = 0;
  }

  each(callback) {
    for (let item = this.first(); this.hasNext(); item = this.next()) {
      callback(item);
    }
  }
}

const items = ['one', 2, 'circle', true, 'Applepie'];
const iter = new IteratorPattern(items);

iter.each(function (item) {
  console.log(item);
});
