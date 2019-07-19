const express = require("express");
const app = express();
const v = require("node-input-validator");

app.use(express.json());

const courses = [
  { id: 1, name: "mathematics" },
  { id: 2, name: "science" },
  { id: 3, name: "history" }
];
app.get("/", (req, res) => {
  res.send("Hello world");
});

app.get("/api/courses", (req, res) => {
  res.send(courses);
});

app.get("/api/courses/:id", (req, res) => {
  const course = courses.find(c => c.id === parseInt(req.params.id));
  if (!course) res.status(404).send("Course not found with given id");
  res.send(course);
});

app.get("/api/posts/:year/:month", (req, res) => {
  console.log(req.query);
  res.send(req.params);
});

app.post("/api/courses", (req, res) => {
  const course = {
    id: courses.length + 1,
    name: req.body.name
  };
  courses.push(course);
  res.send(course);
});

app.put("/api/courses", (req, res) => {
  let validator = validateCourse(req.body);
  console.log(JSON.stringify(validator));
  let { errors } = validator;
  if (errors) {
    res
      .status(400)
      .send(
        "To update course should have id and name with length more than 3 char"
      );
    return;
  }
  //code to update record
  res.send(req.body);
});

const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Listening port ${port} `);
});

let validateCourse = course => {
  let validator = new v(
    { id: "", name: "" },
    { id: "required", name: "required|minLength:3" }
  );
  validator.check();
  return validator;
};
