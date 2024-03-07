import React from "react";
import Dashboard from "./Dashboard";
import Quiz from "./Quiz";
import Result from "./Result";
import Upload from "./Upload";
import Question from "./Question";


const Render = ({ selectedOption }) => {
  switch (selectedOption) {
    case "dashboard":
      return <Dashboard />;
    case "quiz":
      return <Quiz />;
    case "result":
      return <Result />;
    case "upload":
        return <Upload />;
    case "question":
        return <Question />;
    default:
      return <Dashboard />;
  }
};

export default Render;
