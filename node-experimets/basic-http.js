const http = require("http");
const server = http.createServer((req, res) => {
  if (req.url == "/") {
    res.write("hello world !");
  }
  if (req.url == "/api/courses") {
    res.write(JSON.stringify(["history", "mathematics", "politics"]));
  }
  res.end();
});
server.on("connection", scocket => {
  console.log("New connection....");
});
server.listen(3000);
console.log("Listening to port 3000");
