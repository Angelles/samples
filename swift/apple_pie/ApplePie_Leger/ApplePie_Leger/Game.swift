//
//  Game.swift
//  ApplePie_Leger
//
//  Created by Angelle Leger on 2/9/24.
//  Copyright © 2024 Angelle Leger Rutgers University. All rights reserved.
// “On my honor, I have neither received nor given any unauthorized assistance on this assignment." Angelle Leger
//

import Foundation
struct Game {
    var word: String // Variable for the guessed word.
    var incorrectMovesRemaining: Int // Variable for containing the number of incorrect moves remaining.
    var guessedLetters: [Character] // Variable for containing an array of guessed characters.
    var formattedWord: String { // A version of the word that hides the missing letters.
        var guessedWord = ""
        for letter in word {
            if guessedLetters.contains(letter) {
                guessedWord += "\(letter)"
            } else {
                guessedWord += "_"
            }
        }
        return guessedWord
    }
    
    // Keep track of selected letters.
    mutating func playerGuessed(letter: Character){
        guessedLetters.append(letter)
        if !word.contains(letter) {
            incorrectMovesRemaining -= 1
        }
    }
    
}
