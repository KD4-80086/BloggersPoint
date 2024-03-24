import React, { useState } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
function ReadMore({ text, maxLength=100 }) {
  const [isTruncated, setIsTruncated] = useState(true);

  const words = text.split(' ');
  const toggleIsTruncated = () => {
    setIsTruncated(!isTruncated);
  };

  return (
    <div>
      {isTruncated ? (
        <p>
          {text.length <= maxLength ? text : `${text.slice(0, maxLength)}...`}
          <a className="text-blue-500 underline" onClick={toggleIsTruncated}>Read more</a>
        </p>
      ) : (
        <p>
          {text}
          <a className="text-blue-500 underline" onClick={toggleIsTruncated}>show less</a>
        </p>
      )}
    </div>
  );
}

export default ReadMore;
