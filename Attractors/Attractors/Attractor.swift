//
//  Attractor.swift
//  Attractors
//
//  Created by Fernando Domínguez on 13/12/16.
//  Copyright © 2016 Fernando Domínguez. All rights reserved.
//

import SceneKit

protocol Attractor {
    func getPoints() -> [SCNVector3]
}
