//
//  ViewController.swift
//  LightApp_Leger
//
//  Created by Angelle Leger on 2/6/24.
//

import UIKit

class ViewController: UIViewController {

    var lightOn = true
    @IBAction func buttonPressed(_ sender: Any) {
        lightOn.toggle()
        if lightOn {
            view.backgroundColor = .white
        } else {
            view.backgroundColor = .black
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}


