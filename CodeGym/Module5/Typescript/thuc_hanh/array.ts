const list: number[] = [1, 2, 3];

const categories: Array<string> =
    ['Sport', 'IT', 'Car'];

document.write('list ' );
list.forEach((num) =>
    document.write(num.toFixed(2) + "<br>")
);

document.write('categories ');
categories.forEach((str) =>
    document.write(str.indexOf('IT') + "<br>")
);

// convert mảng từ dạng này sang dạng khác.
const listSquare = list.map(num => num * num);
document.write(listSquare + "<br>");
// Output: [1, 4, 9]

// lọc các phần tử thỏa mãn
const result = categories.filter(str => str.length > 2);
document.write(result + "<br>");
// Output: ['Sport', 'Car']
