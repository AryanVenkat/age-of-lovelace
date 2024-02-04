import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomePage from "./HomePage"; // Import HomePage
import RegistrationPage from "./RegistrationPage"; // Make sure the path matches where your RegistrationPage component is located
import TimelinePage from "./TimelinePage";
import TypingAnimation from "./TypingAnimation";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <nav className="Menu-bar">
            <Link to="/">Home</Link>
            <Link to="/about">About</Link>
            <Link to="/contact">Who is Ada Lovelace?</Link>
            <Link to="/learn-more">Learn more</Link>
            <Link to="/talk-to-us">Talk to us</Link>
          </nav>
        </header>
        <Routes>
          <Route path="/" element={<HomePage />} exact />
          <Route path="/timeline" element={<TimelinePage />} />
          <Route path="/register" element={<RegistrationPage />} />

          {/* Add more routes as needed */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
