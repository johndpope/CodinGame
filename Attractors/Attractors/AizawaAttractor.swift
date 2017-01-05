//
//  AizawaAttractor.swift
//  Attractors
//
//  Created by Fernando Domínguez on 13/12/16.
//  Copyright © 2016 Fernando Domínguez. All rights reserved.
//

import SceneKit

class AizawaAttractor : Attractor {
    
    let n : Int
    var x, y, z : Double
    
    init(n: Int, x : Double = 0.1, y : Double = 0.0, z : Double = 0.0) {
        self.n = n
        self.x = x
        self.y = y
        self.z = z
    }
    
    func getPoints() -> [SCNVector3] {
        var points : [SCNVector3] = []
        // Constants
        let dt = 0.01
        let epsilon = 0.25, alpha = 0.95, beta = 0.7
        let gamma = 0.6, delta = 3.5, zeta = 0.1
        
        for _ in 1...self.n {
            let dx = (z - beta) * x - delta * y
            let dy = delta * x + (z - beta) * y
            let dz = gamma + alpha * z - pow(z, 3)/3 - (pow(x, 2) + pow(y, 2)) * (1 + epsilon * z) + zeta * z * pow(x,3)
            x += dx * dt
            y += dy * dt
            z += dz * dt
            
            points.append(SCNVector3(x: CGFloat(x), y: CGFloat(y), z: CGFloat(z)))
        }
        return points
    }
}
