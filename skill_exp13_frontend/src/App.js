
import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/students")
      .then(res => setStudents(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
      <h2>Skill Exp13 Frontend</h2>
      <ul>
        {students.map((s, index) => (
          <li key={index}>
            {s.name} - {s.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
