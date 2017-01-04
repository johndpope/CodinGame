//
//  GameViewController.swift
//  Attractors
//
//  Created by Fernando Domínguez on 13/12/16.
//  Copyright (c) 2016 Fernando Domínguez. All rights reserved.
//

import SceneKit
import QuartzCore

class GameViewController: NSViewController {
    
    @IBOutlet weak var gameView: GameView!
    
    var scene : SCNScene!
    
    override func awakeFromNib(){
        super.awakeFromNib()
        
        // create a new scene
        scene = SCNScene()
        
        // create and add a camera to the scene
        let cameraNode = SCNNode()
        cameraNode.camera = SCNCamera()
        scene.rootNode.addChildNode(cameraNode)
        
        // place the camera
        cameraNode.position = SCNVector3(x: 0, y: 0, z: 60)
        
        // create and add a light to the scene
        let lightNode = SCNNode()
        lightNode.light = SCNLight()
        lightNode.light!.type = .omni
        lightNode.position = SCNVector3(x: 0, y: 10, z: 10)
        scene.rootNode.addChildNode(lightNode)
        
        // create and add an ambient light to the scene
        let ambientLightNode = SCNNode()
        ambientLightNode.light = SCNLight()
        ambientLightNode.light!.type = .ambient
        ambientLightNode.light!.color = NSColor.darkGray
        scene.rootNode.addChildNode(ambientLightNode)
        
        // Draw each point
        var hue = 0.0
        var vertices : [PointCloudVertex] = []
        let points = LorenzAttractor(n: 40000).getPoints()
        for p in points {
            let color = NSColor(calibratedHue: CGFloat(hue), saturation: 0.6, brightness: 1.0, alpha: 1.0)
            let v = PointCloudVertex(
                x: Double(p.x),
                y: Double(p.y),
                z: Double(p.z),
                r: Double(color.redComponent),
                g: Double(color.greenComponent),
                b: Double(color.blueComponent)
            )
            vertices.append(v)
            hue += 0.0001;
            if hue > 1 {
                hue = 0
            }
        }
        
        let attractorNode = buildAttractorNode(points: vertices)
        scene.rootNode.addChildNode(attractorNode)
        
        // animate the 3d object
        /*let animation = CABasicAnimation(keyPath: "rotation")
        animation.toValue = NSValue(scnVector4: SCNVector4(x: CGFloat(0), y: CGFloat(1), z: CGFloat(0), w: CGFloat(M_PI)*2))
        animation.duration = 30
        animation.repeatCount = MAXFLOAT //repeat forever
        attractorNode.addAnimation(animation, forKey: nil)*/

        // set the scene to the view
        self.gameView!.scene = scene
        // allows the user to manipulate the camera
        self.gameView!.allowsCameraControl = true
        // show statistics such as fps and timing information
        self.gameView!.showsStatistics = true
        // configure the view
        self.gameView!.backgroundColor = NSColor.black
    }
    
    // Thanks SO
    // http://stackoverflow.com/questions/32712268/how-to-use-scenekit-to-display-a-colorful-point-cloud-using-custom-scngeometry
    func buildAttractorNode(points: [PointCloudVertex]) -> SCNNode {
        let vertexData = NSData(
            bytes: points,
            length: MemoryLayout<PointCloudVertex>.size * points.count
        )
        let positionSource = SCNGeometrySource(
            data: vertexData as Data,
            semantic: SCNGeometrySource.Semantic.vertex,
            vectorCount: points.count,
            usesFloatComponents: true,
            componentsPerVector: 3,
            bytesPerComponent: MemoryLayout<Float>.size,
            dataOffset: 0,
            dataStride: MemoryLayout<PointCloudVertex>.size
        )
        let colorSource = SCNGeometrySource(
            data: vertexData as Data,
            semantic: SCNGeometrySource.Semantic.color,
            vectorCount: points.count,
            usesFloatComponents: true,
            componentsPerVector: 4,
            bytesPerComponent: MemoryLayout<Float>.size,
            dataOffset: 0,
            dataStride: MemoryLayout<float4>.size
        )
        let elements = SCNGeometryElement(
            data: nil,
            primitiveType: .point,
            primitiveCount: points.count,
            bytesPerIndex: MemoryLayout<Int>.size
        )
        let pointCloud = SCNGeometry(sources: [positionSource, colorSource], elements: [elements])
        
        return SCNNode(geometry: pointCloud)
    }
}
