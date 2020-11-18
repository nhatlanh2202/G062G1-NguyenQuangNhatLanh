var list = [1, 2, 3];
var categories = ['Sport', 'IT', 'Car'];
document.write('list ');
list.forEach(function (num) {
    return document.write(num.toFixed(2) + "<br>");
});
document.write('categories ');
categories.forEach(function (str) {
    return document.write(str.indexOf('IT') + "<br>");
});
// convert mảng từ dạng này sang dạng khác.
var listSquare = list.map(function (num) { return num * num; });
document.write(listSquare + "<br>");
// Output: [1, 4, 9]
// lọc các phần tử thỏa mãn
var result = categories.filter(function (str) { return str.length > 2; });
document.write(result + "<br>");
// Output: ['Sport', 'Car']
