import React, { useState, useEffect } from "react";
import axios from "axios";

const Question = () => {
  const [questions, setQuestions] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Fetch questions from the API
    axios
      .get("http://localhost:8080/api/questions")
      .then((response) => {
        setQuestions(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching questions:", error);
        setLoading(false);
      });
  }, []);

  return (
    <div className="container mx-auto mt-8">
      <h1 className="text-3xl font-bold mb-4">All Questions for Practice</h1>

      {loading ? (
        <>
        <div className="flex items-center justify-center w-56 h-56 border border-gray-200 rounded-lg ">
          <div className="px-3 py-1 text-xs font-medium leading-none text-center text-blue-800 bg-blue-200 rounded-full animate-pulse dark:bg-blue-900 dark:text-blue-200">
            Loading...
          </div>
        </div>
        
        </>
      ) : (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {questions.map((question) => (
            <div key={question.test_data_id} className="bg-white p-4 rounded shadow">
              <p className="text-xl font-bold mb-2">{question.question_text}</p>
              <ul>
                <li>A. {question.option_a}</li>
                <li>B. {question.option_b}</li>
                <li>C. {question.option_c}</li>
                <li>D. {question.option_d}</li>
              </ul>
              <p className="mt-2">Correct Answer: {question.correct_option}</p>
              <p>Difficulty Level: {question.difficulty_level}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Question;
