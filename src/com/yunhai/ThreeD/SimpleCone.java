package com.yunhai.ThreeD;

import java.applet.Applet;
import java.awt.BorderLayout;

import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;


 
 

public class SimpleCone extends Applet{
	public BranchGroup createSceneGraph() {
		BranchGroup objRoot = new BranchGroup();
		TransformGroup objTrans = new TransformGroup();
		objRoot.addChild(objTrans);
		
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100.0);
		
		Color3f bgColor = new Color3f(1.0f,1.0f,1.0f);
		Background bg = new Background(bgColor);
		bg.setApplicationBounds(bounds);
		objRoot.addChild(bg);
		
		Color3f directionalColor = new Color3f(1.f,1.f,1.f);
		Vector3f vec=new Vector3f(0.f,0.f,-1.0f);
		DirectionalLight directionalLight=new DirectionalLight(directionalColor,vec);
		directionalLight.setInfluencingBounds(bounds);
		objRoot.addChild(directionalLight);
		
		Appearance app=new Appearance();
		Material material=new Material();
		material.setEmissiveColor(new Color3f(1.0f,0.0f,0.0f));
		app.setMaterial(material);
		Cone cone=new Cone(.5f,1.0f,1,app);
		objTrans.addChild(cone);
		
		objRoot.compile();
		
		return objRoot;
	}
	
	public SimpleCone() {			//程序的構造方法
		setLayout(new BorderLayout());
		//Canvas3D c=new Canvas3D(null);//原始程序
		Canvas3D c=new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		add("Center",c);
		BranchGroup scene=createSceneGraph();
		SimpleUniverse u =new SimpleUniverse(c);
		u.getViewingPlatform().setNominalViewingTransform();
		u.addBranchGraph(scene);
		
	}
	public static void main(String[] args) {//使程序尤為Application類型程序的方法
		new MainFrame(new SimpleCone(),400,300);
	}
}
