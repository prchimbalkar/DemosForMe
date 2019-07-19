const EventEmitter = require("events");

class Logger extends EventEmitter {
  log(message) {
    console.log(message);
    this.emit("messageLogged", { url: "/some-url", name: "google url" });
  }
}
module.exports = Logger;
