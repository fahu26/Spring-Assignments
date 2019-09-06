package com.fahim;

import javax.annotation.Resource;
import javax.inject.Inject;

public class Triangle implements Shapes{
private Point pointA;
private Point pointB;
private Point pointC;
public Point getPointA() {
	return pointA;
}
public void setPointA(Point pointA) {
	this.pointA = pointA;
}
public Point getPointB() {
	return pointB;
}
@Inject
public void setPointB(Point pointB) {
	this.pointB = pointB;
}
public Point getPointC() {
	return pointC;
}
@Resource
public void setPointC(Point pointC) {
	this.pointC = pointC;
}

@Override
public void draw() {
	System.out.println("Drawing Triangle");
	System.out.println("Point A: "+pointA.getX()+","+pointA.getY());
	System.out.println("Point B: "+pointB.getX()+","+pointB.getY());
	System.out.println("Point C: "+pointC.getX()+","+pointC.getY());
	
}


}
