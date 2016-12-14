//
//  LorenzAttractor.swift
//  Attractors
//
//  Created by Fernando Domínguez on 13/12/16.
//  Copyright © 2016 Fernando Domínguez. All rights reserved.
//

import SceneKit

class AnishchenkoAttractor : Attractor {
    
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
        let u = 1.2, n = 0.5
        
        for _ in 1...self.n {
            let dx = (u * x + y - x * z) * dt
            let dy = (-x) * dt
            let dz = (-n * z + n * I(x) * pow(x,2)) * dt
            x += dx
            y += dy
            z += dz
            
            points.append(SCNVector3(x: CGFloat(x), y: CGFloat(y), z: CGFloat(z)))
        }
        return points
    }
    
    func I(_ x : Double) -> (Double) {
        if x > 0 {
            return 1.0
        }
        return 0.0;
    }
}
