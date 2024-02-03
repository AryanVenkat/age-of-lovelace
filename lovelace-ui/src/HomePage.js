// src/HomePage.js
import React from 'react';
import { useNavigate, Link } from 'react-router-dom';


function HomePage() {
  let navigate = useNavigate();

  return (
    <div>
      <img src="images/aol-logo-nobg.png" alt="Ada Lovelace" className="Center-image"/>
      <h1>Age Of Lovelace</h1>
      <p className="Caption-text">Discover how you aged through Digital Revolution.</p>
      <Link to="/register" className="Learn-more">What is Digital Revolution? </Link>
      <button 
        className="Get-started" 
        onClick={() => navigate('/register')}
      >
        Take me on this journey 🚀
      </button>
    </div>
  );
}

export default HomePage;
