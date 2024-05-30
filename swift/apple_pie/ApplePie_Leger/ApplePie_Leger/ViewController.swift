//
//  ViewController.swift
//  ApplePie_Leger
//
//  Created by Angelle Leger on 2/6/24.
// “On my honor, I have neither received nor given any unauthorized assistance on this // assignment." Angelle Leger
//

import UIKit

class ViewController: UIViewController {
    // The following variables and constants are part of the Apple Pie game logic.
    var listOfWords = ["buccaneer", "swift", "glorious", "incandescent", "bug", "program"] // A list of words for the game.
    let incorrectMovesAllowed = 7     // The number of incorrect moves allowed in the game.
    var totalWins = 0 {    // totalWins and totalLosses are variables for tracking the total wins and losses.
        didSet {
            newRound()
        }
    }
    var totalLosses = 0 {
        didSet {
            newRound()
        }
    }
    var currentGame: Game!     // A variable for holding the current game.
    
    // Outlets for UI elements.
    @IBOutlet var correctWordLabel: UILabel!
    @IBOutlet var scoreLabel: UILabel!
    @IBOutlet var letterButtons: [UIButton]!
    @IBOutlet var treeImageView: UIImageView!
    
    @IBAction func letterButtonPressed(_ sender: UIButton) {
        sender.isEnabled = false
        let letterString = sender.configuration!.title! // let letterString = sender.title(for: .normal)! does not work, due to recent updates from Apple.
        let letter = Character(letterString.lowercased())
        currentGame.playerGuessed(letter: letter)
        updateGameState()
    }
    
    // Update the wins and losses.
    func updateGameState(){
        if currentGame.incorrectMovesRemaining == 0 {
            totalLosses += 1
        } else if currentGame.word == currentGame.formattedWord {
            totalWins += 1
        } else {
            updateUI()
        }
    }
    // Start a new round after the view loads.
    override func viewDidLoad() {
        super.viewDidLoad()
        newRound()
    }
    
    // Start a new round.
    func newRound(){
        if !listOfWords.isEmpty {
            let newWord = listOfWords.removeFirst()
            currentGame = Game(word: newWord, incorrectMovesRemaining: incorrectMovesAllowed, guessedLetters: [])
            enableLetterButtons(true)
            updateUI()
        } else {
            enableLetterButtons(false)
        }
    }
        
    // Update the UI with the total wins, total losses, and the number of incorrect moves remaining.
    func updateUI(){
        var letters = [String]()
        for letter in currentGame.formattedWord {
            letters.append(String(letter))
        }
        let wordWithSpacing = letters.joined(separator: " ")
        correctWordLabel.text = wordWithSpacing
        scoreLabel.text = "Wins: \(totalWins), Losses: \(totalLosses)"
        treeImageView.image = UIImage(named:"Tree \(currentGame.incorrectMovesRemaining)")
    }
        
    // Enable (or disable) the letter buttons.
    func enableLetterButtons(_ enable: Bool) {
        for button in letterButtons {
            button.isEnabled = enable
        }
    }
        
    }
    
