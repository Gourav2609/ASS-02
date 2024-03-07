import React, { useState, useEffect } from "react";
import axios from "axios";

const Result = () => {
  const [quizResults, setQuizResults] = useState([]);
  const username = localStorage.getItem("username");

  useEffect(() => {
    // Fetch quiz results from the API for the specific username
    if (username) {
      axios
        .get(`http://localhost:8080/api/quiz-results/all?username=${username}`)
        .then((response) => setQuizResults(response.data))
        .catch((error) => console.error("Error fetching quiz results:", error));
    }
  }, [username]);

  return (
    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr className="">
            <th scope="col" className="px-6 py-3">
              Quiz Name
            </th>
            <th scope="col" className="px-6 py-3">
              Easy
            </th>
            <th scope="col" className="px-6 py-3">
              Medium
            </th>
            <th scope="col" className="px-6 py-3">
              Hard
            </th>
            <th scope="col" className="px-6 py-3">
              Score
            </th>
          </tr>
        </thead>
        <tbody>
          {quizResults.map((result, index) => (
            <tr
              key={index}
              className="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700"
            >
              <th
                scope="row"
                className="px-6 py-4 font-medium text-black whitespace-nowrap dark:text-white"
              >
                Quiz {index + 1}
              </th>
              <td className="px-6 py-4">{result.easyQuestions}</td>
              <td className="px-6 py-4">{result.mediumQuestions}</td>
              <td className="px-6 py-4">{result.hardQuestions}</td>
              <td className="px-6 py-4">{result.score} / 10</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Result;
