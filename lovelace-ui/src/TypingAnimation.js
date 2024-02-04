import React, { useEffect, useState } from "react";

function TypingAnimation({ text }) {
  const [displayText, setDisplayText] = useState("");
  const typingSpeed = 25; // Adjust the speed here (lower value = faster)

  useEffect(() => {
    let currentIndex = 0;
    const typeText = () => {
      if (currentIndex < text.length) {
        setDisplayText((prevText) => prevText + text[currentIndex]);
        currentIndex++;
        setTimeout(typeText, typingSpeed);
      }
    };
    typeText();
  }, [text]);

  return <span>{displayText}</span>;
}

export default TypingAnimation;
