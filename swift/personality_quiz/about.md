# Personality Quiz

The Personality Quiz app includes one quiz: "What Animal Are You?" Users are presented with a screen with the quiz title and emojis that indicate more about the quiz. After the user taps the button to start the quiz, questions and answers appear modally in a separate view. A third view presents the user with the results after the user answers all of the questions. The user may go back and take the quiz again or exit the app.

Note that this app follows the model-view-controller (MVC) design pattern. 
- The app's models are defined in one file.
- Views are controlled by separate view controllers.
  - In this app, there are three view controllers: introduction, question, and results views.
  - The question view is updated to display the next question after the user answers a question. Only one question and set of answer options is displayed at a time.
- A navigation view controller helps manage the transitions between views.

**Note:** I used Xcode Version 15.1 to build this app.
