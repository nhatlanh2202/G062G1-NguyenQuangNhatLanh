var count = 50;
if (count > 0) {
    count--;
}
else {
    count = 0;
}
// console.log(count);
document.write("" + count + "<br>");
/**
 * loop
 */
document.writeln("for loop" + "<br>");
var keys = "abcdef";
for (var idx_1 = 0; idx_1 < keys.length; ++idx_1) {
    document.writeln(keys[idx_1] + "<br>");
}
document.writeln("while loop" + "<br>");
var idx = 0;
while (idx < keys.length) {
    document.writeln(keys[idx] + "<br>");
    ++idx;
}
document.writeln("do-while loop" + "<br>");
idx = 0;
do {
    document.writeln(keys[idx] + "<br>");
    ++idx;
} while (idx < keys.length);
document.writeln("for-of loop" + "<br>");
for (var _i = 0, keys_1 = keys; _i < keys_1.length; _i++) {
    var item = keys_1[_i];
    document.writeln(item + "<br>");
}
document.writeln("for-in loop" + "<br>");
var user = {
    name: 'Bob',
    age: 55
};
for (var key in user) {
    document.writeln(key + ": " + user[key] + "<br>");
}
