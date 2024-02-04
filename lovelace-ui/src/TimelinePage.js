import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import "./TimelinePage.css";
import TypingAnimation from "./TypingAnimation";
import "./ImageLoadingEffect.css";

function TimelinePage() {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const name = queryParams.get("name");
  const birthYear = queryParams.get("birthYear");
  const gender = queryParams.get("gender");

  const [timelineData, setTimelineData] = useState(null);
  const [displayText, setDisplayText] = useState(""); // State to store the displayed text

  useEffect(() => {
    // Fetch the JSON data file
    fetch("timelineData.json") // Replace with the actual path to your JSON file
      .then((response) => response.json())
      .then((data) => {
        setTimelineData(data);
        setDisplayText(data[0].lifeEventNarrative); // Initialize with the first entry
      })
      .catch((error) => {
        console.error("Error fetching JSON data:", error);
      });
  }, []);

  if (!timelineData) {
    return <div>Loading...</div>; // You can display a loading message while fetching data
  }

  const currentIndex = timelineData.findIndex(
    (entry) => entry.lifeEventNarrative === displayText
  );

  const handleNext = () => {
    const nextIndex = currentIndex + 1;
    if (nextIndex < timelineData.length) {
      setDisplayText(timelineData[nextIndex].lifeEventNarrative);
    }
  };

  const handlePrevious = () => {
    const previousIndex = currentIndex - 1;
    if (previousIndex >= 0) {
      setDisplayText(timelineData[previousIndex].lifeEventNarrative);
    }
  };

  return (
    <div className="timeline-page">
      <div className="timeline-left">
        <img
          src={timelineData[currentIndex].lifeEventImageUrl}
          alt="Life Event"
          className="image-loading"
        />
        <TypingAnimation text={displayText}></TypingAnimation>
      </div>
      <div className="timeline-center">
        <h2>{timelineData[currentIndex].year}</h2>
      </div>
      <div className="timeline-right">
        <img
          src={timelineData[currentIndex].techEventImageUrl}
          alt="Tech Event"
          className="image-loading"
        />
        <TypingAnimation
          text={timelineData[currentIndex].techEventNarrative}
        ></TypingAnimation>
      </div>
      <div className="timeline-buttons">
        <button className="previous-button" onClick={handlePrevious}>
          Previous
        </button>
        <button className="next-button" onClick={handleNext}>
          Next
        </button>
      </div>
    </div>
  );
}
export default TimelinePage;
