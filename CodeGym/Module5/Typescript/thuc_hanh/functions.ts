
function square(num: number): number {
    return num * num;
};

document.write(square(5) + "<br>");


// Function expression
const squareFE = function (num: number): number {
    return num * num;
};
document.write(squareFE(9) + "<br>");


    // Higher-order function
    function add(a: number): Function {
        return function(b: number): number {
            return a + b;
        }
    }

const addWith5 = add(5);
document.write(addWith5(3) + "<br>");
document.write(addWith5(15));
