import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Login from "./screens/login";
import Home from "./screens/home";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" />
        <Route path="/home" element={<Home />} />
      </Routes>
    </Router>
  );
}

export default App;
