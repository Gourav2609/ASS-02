# Dynamic Assessment App

Welcome to the Assessment App! This application allows users to take a quiz with questions of varying difficulty levels.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)

## Features

- Fetches questions from an API and shuffles them for a randomized quiz experience.
- Dynamically adjusts difficulty levels based on user performance.
- Calculates and displays the user's quiz score.
- Sends quiz results to a server for storage.
- Responsive design for various screen sizes.

## Getting Started

### Prerequisites

Make sure you have Node.js and npm installed on your machine.

- Node.js: [Download here](https://nodejs.org/)
- npm: Included with Node.js installation
- Maven: [Download here](https://maven.apache.org/download.cgi)
- Java: [Download here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- PostgresSQL: [Download here](https://www.postgresql.org/download/)


### Installation

#### Front-End

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/react-quiz-app.git


2. Navigate to the Front-End Directory
 
   ```bash
   cd Front-end
   ```

3. Install the required packages:

   ```bash
    npm install
    ```

4. Start the application:

   ```bash
   npm run dev
   ```

#### Back-End

1. In The Root Directory

   ```bash
   mvn spring-boot:run
   ```


This will start the backend server on port 8080 and the front-end server on port 3000.


## API Reference

1. /api/users
    - GET: Get all users

2. /api/auth/login
    - POST: Login user

3. /api/questions
    - GET: Get all questions

4. /api/quiz-results
    -POST: /save - Save quiz result
    -GET: /all - Get quiz results of all the users

5. /upload
    -POST: Extract question from a excel .xlsx file and save it to the database



#### Since the project is in development, application.properties file is included in the repository. The PostgresSQL database is hosted on Render and the credentials are included in the application.properties file.


## Usage

1. Go to /login and login with the following credentials:
    - Username: test
    - Password: root

2. Take the quiz and see the results in the Results.

3. To upload a new set of questions, go to Upload tab and upload the .xlsx file.

4. To see all the question in the database, go to the questions tab.