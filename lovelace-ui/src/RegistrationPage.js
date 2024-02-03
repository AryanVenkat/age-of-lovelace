import React from 'react';
import './RegistrationPage.css'; // Assuming you have a separate CSS file for styling

function RegistrationPage() {
  return (
    <div className="registration-page">
      <div className="form-container">
        <h2>Tell us about yourself</h2>
        <form>
          <div className="form-field">
            <label htmlFor="name">Name:</label>
            <input type="text" id="name" name="name" />
          </div>
          <div className="form-field">
            <label htmlFor="birthYear">Birth Year:</label>
            <select id="birthYear" name="birthYear">
              <option value="1991">1991</option>
              <option value="1992">1992</option>
              {/* Additional options */}
            </select>
          </div>
          <div className="form-field">
            <label htmlFor="gender">Gender:</label>
            <select id="gender" name="gender">
              <option value="male">Male</option>
              <option value="female">Female</option>
              {/* Additional options */}
            </select>
          </div>
          <button type="submit" className="submit-button">Generate my timeline 🚀</button>
        </form>
      </div>
      <div className="image-container">
        <img src="images/lovelace-nobg.png" alt="Ada Lovelace" />
      </div>
    </div>
  );
}

export default RegistrationPage;
