import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <nav className="Menu-bar">
          <a href="#home">Home</a>
          <a href="#about">About</a>
          <a href="#contact">Who is Ada Lovelace?</a>
          <a href="#about">Learn more</a>
          <a href="#about">Talk to us</a></nav>
        <img src="aol-logo-nobg.png" alt="Ada Lovelace" className="Center-image"/>
        <h1>Age Of Lovelace</h1>
        <p className="Caption-text">Discover how you aged through Digital Revolution.</p>
        <a className="Learn-more" href="">What is Digital Revolution? </a>
        <button className="Get-started">Take me on this journey 🚀</button>
      </header>
    </div>
  );
}

export default App;
