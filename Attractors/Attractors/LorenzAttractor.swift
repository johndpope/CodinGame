//
//  LorenzAttractor.swift
//  Attractors
//
//  Created by Fernando Domínguez on 13/12/16.
//  Copyright © 2016 Fernando Domínguez. All rights reserved.
//

import SceneKit

class LorenzAttractor : Attractor {
    
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
        let sigma = 10.0, rho = 28.0, beta = 8.0/3.0
        
        for _ in 1...self.n {
            let dx = sigma * (y - x) * dt
            let dy = (x * (rho - z) - y) * dt
            let dz = (x * y - beta * z) * dt
            x += dx
            y += dy
            z += dz
            
            points.append(SCNVector3(x: CGFloat(x), y: CGFloat(y), z: CGFloat(z)))
        }
        return points
    }
}
