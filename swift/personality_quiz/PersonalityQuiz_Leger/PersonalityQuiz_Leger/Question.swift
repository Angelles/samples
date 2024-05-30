//
//  Question.swift
//  PersonalityQuiz_Leger
//
//  Created by Angelle Leger on 2/17/24.
// “On my honor, I have neither received nor given any unauthorized assistance on this assignment.” - Angelle Leger

import Foundation

struct Question { // Question objects include a string, a question response type, and an answer (see QuestionViewController).
    var text: String
    var type: ResponseType
    var answers: [Answer]
}

enum ResponseType {
    case single, multiple, ranged // Different response types available in the quiz.
}

struct Answer {  // Answer objects include a string and a type. The type is tied to answers (see Answer objects in the QuestionViewController).
    var text: String
    var type: AnimalType
}

enum AnimalType: Character { // Definitions of the animal types (the possible quiz results).
    case dog = "🐶", cat = "🐱", rabbit = "🐰", turtle = "🐢"
    var definition: String {
        switch self {
        case .dog:
            return "You are incredibly outgoing. You surround yourself with the people you love and enjoy activities with your friends."
        case .cat:
            return "Mischievous, yet mild-tempered, you enjoy doing things on your own terms."
        case .rabbit:
            return "You love everything that's soft. You are healthy and full of energy."
        case .turtle:
            return "You are wise beyond your years, and you focus on the details. Slow and steady wins the race."
        }
    }
}

