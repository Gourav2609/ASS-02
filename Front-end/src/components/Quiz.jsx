import React, { useState, useEffect } from "react";
import axios from "axios";

const TOTAL_QUESTIONS = 10;

const shuffleArray = (array) => {
  // Shuffle the array using Fisher-Yates algorithm
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
};

const Quiz = () => {
  const [questions, setQuestions] = useState([]);
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [userAnswers, setUserAnswers] = useState({});
  const [quizCompleted, setQuizCompleted] = useState(false);
  const [score, setScore] = useState(null);
  const [easyQuestions, setEasyQuestions] = useState(0);
  const [mediumQuestions, setMediumQuestions] = useState(0);
  const [hardQuestions, setHardQuestions] = useState(0);
  const [datasend, setDatasend] = useState(false);

  useEffect(()=>{
    if(quizCompleted && !datasend){
      calculateScore();
      setDatasend(true);
    }
  } , [quizCompleted, datasend])

  useEffect(() => {
    // Fetch questions from the API
    axios
      .get("http://localhost:8080/api/questions")
      .then((response) => {
        const shuffledQuestions = [...response.data];
        shuffleArray(shuffledQuestions);
        setQuestions(shuffledQuestions);
      })
      .catch((error) => console.error("Error fetching questions:", error));
  }, []);

  const handleAnswerSelection = (selectedOption) => {
    setUserAnswers({ ...userAnswers, [currentQuestionIndex]: selectedOption });
  };

  useEffect(() => {
    console.log("Easy Questions:", easyQuestions);
    console.log("Medium Questions:", mediumQuestions);
    console.log("Hard Questions:", hardQuestions);
  }, [easyQuestions, mediumQuestions, hardQuestions]);
  

  const handleNextQuestion = () => {
    setCurrentQuestionIndex(currentQuestionIndex + 1);
    if (currentQuestionIndex < TOTAL_QUESTIONS - 1) {
      const currentQuestion = questions[currentQuestionIndex];
      const currentDifficulty = currentQuestion.difficulty_level;

      if (currentDifficulty === "easy") {
        setEasyQuestions((prevEasyQuestions) => prevEasyQuestions + 1);
      } else if (currentDifficulty === "medium") {
        setMediumQuestions((prevMediumQuestions) => prevMediumQuestions + 1);
      } else {
        setHardQuestions((prevHardQuestions) => prevHardQuestions + 1);
      }

      // Check if the user's answer is correct
      const isCorrect =
        userAnswers[currentQuestionIndex] === currentQuestion.correct_option;

      if (isCorrect) {
        console.log("Thats a correct answer");
      }

      // Improve the logic for determining the next difficulty level
      const difficultyLevels = ["easy", "medium", "hard"];
      const nextDifficulty = isCorrect
        ? difficultyLevels[difficultyLevels.indexOf(currentDifficulty) + 1] ||
          "hard"
        : difficultyLevels[difficultyLevels.indexOf(currentDifficulty) - 1] ||
          "easy";

      // Find questions for the next difficulty level
      const questionsInNextDifficulty = questions.filter(
        (q) => q.difficulty_level === nextDifficulty
      );

      // Set the next question with the updated difficulty level
      const nextIndex =
        questionsInNextDifficulty.length > 0
          ? questions.indexOf(
              questionsInNextDifficulty[
                currentQuestionIndex % questionsInNextDifficulty.length
              ]
            )
          : currentQuestionIndex + 1;
    } else {
      // User has completed the quiz
      setQuizCompleted(true);
      // calculateScore();
    }
  };

  const calculateScore = () => {
    // Calculate the user's score based on correct answers
    const correctAnswers = questions.reduce((count, question, index) => {
      const userAnswer = userAnswers[index];
      return userAnswer && userAnswer === question.correct_option
        ? count + 1
        : count;
    }, 0);

    setScore(correctAnswers);

    // Send the quiz result to the server
    const storedUsername = localStorage.getItem("username");
    const storedEmail = localStorage.getItem("email");

    const quizResultData = {
      username: storedUsername || "Guest",
      email: storedEmail || "guest@example.com",
      totalQuestions: TOTAL_QUESTIONS,
      easyQuestions: easyQuestions,
      mediumQuestions: mediumQuestions,
      hardQuestions: hardQuestions,
      score: correctAnswers,
    };

    axios
      .post("http://localhost:8080/api/quiz-results/save", quizResultData)
      .then((response) =>
        console.log("Quiz result sent successfully:", quizResultData)
      )
      .catch((error) => console.error("Error sending quiz result:", error));
  };

  if (quizCompleted) {
    return (
      <div className="container mx-auto mt-8 text-center">
        <h1 className="text-3xl font-bold mb-4">Quiz Completed!</h1>
        <p>
          Your Score: {score} / {TOTAL_QUESTIONS}
        </p>
        <button
          onClick={() => window.location.reload()}
          className="bg-blue-500 text-white px-4 py-2 mt-4 rounded hover:bg-blue-600"
        >
          Start New Quiz
        </button>
      </div>
    );
  }

  return (
    <div className="container mx-auto mt-8">
      <h1 className="text-3xl font-bold mb-4">Quiz</h1>
      <div className="bg-white p-4 rounded shadow">
        <p className="text-xl font-bold mb-2">
          Question {currentQuestionIndex + 1}/{TOTAL_QUESTIONS}:{" "}
          {questions[currentQuestionIndex]?.question_text} (Difficulty:{" "}
          {questions[currentQuestionIndex]?.difficulty_level})
        </p>
        <ul>
          {["A", "B", "C", "D"].map((option) => (
            <li
              key={option}
              onClick={() => handleAnswerSelection(option)}
              className={`${
                userAnswers[currentQuestionIndex] === option
                  ? "bg-blue-200"
                  : "hover:bg-gray-100"
              } cursor-pointer p-2 rounded transition-colors`}
            >
              {`${option}. ${
                questions[currentQuestionIndex]?.[
                  `option_${option.toLowerCase()}`
                ]
              }`}
            </li>
          ))}
        </ul>
        <button
          onClick={handleNextQuestion}
          className="relative inline-flex items-center justify-center p-0.5 mb-2 me-2 overflow-hidden text-sm font-medium text-white rounded-lg group bg-gradient-to-br from-pink-500 to-orange-400 group-hover:from-pink-500 group-hover:to-orange-400 hover:text-white dark:text-white focus:ring-4 focus:outline-none focus:ring-pink-200 dark:focus:ring-pink-800"
        >
          <span className="relative px-5 py-2.5 transition-all ease-in duration-75 bg-white dark:bg-gray-900 rounded-md group-hover:bg-opacity-0">
            {currentQuestionIndex < TOTAL_QUESTIONS - 1
              ? "Next Question"
              : "Finish Quiz"}
          </span>
        </button>
      </div>
    </div>
  );
};

export default Quiz;
