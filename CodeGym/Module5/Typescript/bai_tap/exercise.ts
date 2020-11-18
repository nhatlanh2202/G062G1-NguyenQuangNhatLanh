interface ISingleRepo {
    name: string;
}
//Khai báo phương thức get data
function httpGet(url: string): Promise<Array<ISingleRepo>> {
    return new Promise(function (resolve, reject) {
        const request = new XMLHttpRequest();
        request.open("GET", url);
        request.send();
        request.onload = function () {
            if (this.status === 200) {
                // Success
                resolve(this.response);
            } else {
                // Something went wrong (404 etc.)
                reject(new Error(this.statusText));
            }
        };
        request.onerror = function () {
            reject(new Error("XMLHttpRequest Error: " + this.statusText));
        };
    });
}
httpGet("https://api.github.com/search/repositories?q=angular")
  .then(function (value) {
    document.getElementById("content").innerText = value.toString();
  })
  .catch(function (reason) {
    console.error("Something went wrong", reason);
  });
// async function getResult() {
//     await httpGet("https://api.github.com/search/repositories?q=angular")
//         .then((value) => document.getElementById("content").innerText = value.toString())
// }
// getResult();
