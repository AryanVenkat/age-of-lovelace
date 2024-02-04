import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./RegistrationPage.css"; // Assuming you have a separate CSS file for styling

function RegistrationPage() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: "",
    birthYear: "",
    gender: "",
  });

  const handleGenerateTimeline = () => {
    // Navigate to the TimelinePage and pass data as URL parameters
    navigate(
      `/timeline?name=${formData.name}&birthYear=${formData.birthYear}&gender=${formData.gender}`
    );
  };

  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent default form submission behavior

    try {
      console.log("form data: ", formData);
      const response = await axios.post("your-api-endpoint", formData);
      // Handle the response from the backend if needed
      console.log("Registration successful:", response.data);
    } catch (error) {
      // Handle errors if the request fails
      console.error("Error:", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  return (
    <div className="registration-page">
      <div className="form-container">
        <h2>Tell us about yourself</h2>
        <form>
          <div className="form-field">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              name="name"
              value={formData.name}
              onChange={handleChange}
            />
          </div>
          <div className="form-field">
            <label htmlFor="birthYear">Birth Year:</label>
            <select
              id="birthYear"
              name="birthYear"
              value={formData.birthYear}
              onChange={handleChange}
            >
              <option value="0">Choose Year</option>
              <option value="1991">1991</option>
              <option value="1992">1992</option>
              {/* Additional options */}
            </select>
          </div>
          <div className="form-field">
            <label htmlFor="gender">Gender:</label>
            <select
              id="gender"
              name="gender"
              value={formData.gender}
              onChange={handleChange}
            >
              <option value="0">Select Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              {/* Additional options */}
            </select>
          </div>

          <button onClick={handleGenerateTimeline} className="submit-button">
            Generate my timeline 🚀
          </button>
        </form>
      </div>
      <div className="image-container">
        <img src="images/lovelace-nobg.png" alt="Ada Lovelace" />
      </div>
    </div>
  );
}

export default RegistrationPage;
