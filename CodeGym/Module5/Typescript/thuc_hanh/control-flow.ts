let count = 50;
if (count > 0) {
    count--;
} else {
    count = 0;
}
// document.write("" + count);
document.write("" + count + "<br>");

/**
 * loop
 */

document.writeln("for loop" + "<br>");

const keys = "abcdef";
for (let idx = 0; idx < keys.length; ++idx) {
    document.writeln(keys[idx] + "<br>");
}

document.writeln("while loop" + "<br>");
let idx = 0;
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
for (let item of keys) {
    document.writeln(item + "<br>");
}

document.writeln("for-in loop" + "<br>");
const user = {
    name: 'Bob',
    age: 55
};
for (let key in user) {
    document.writeln(`${key}: ${user[key]}` + "<br>");
}
