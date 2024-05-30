//
//  ViewController.swift
//  iOSLightApp_Leger
//
//  Created by Angelle Leger on 2/8/24.
//     “On my honor, I have neither received nor given any unauthorized assistance on this assignment.” - Angelle Leger
//

import UIKit

class ViewController: UIViewController {
    var lightOn = false

    @IBOutlet var lightButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        updateUI()
    }
    
    @IBAction func buttonPressed(_ sender: Any) {
        lightOn = !lightOn
        updateUI()
    }
    
    func updateUI(){
        if lightOn{
            view.backgroundColor = .white
            lightButton.setTitle("", for: .normal)
        } else {
            view.backgroundColor = .black
            lightButton.setTitle("", for: .normal)
        }
    }
}
