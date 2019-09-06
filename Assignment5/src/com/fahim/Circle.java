package com.fahim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shapes {
private Point center;

public Point getCenter() {
	return center;
}
@Autowired
@Required
public void setCenter(Point center) {
	this.center = center;
}

@Override
public void draw() {
System.out.println("Drawing Circle");
System.out.println("Center: " +center.getX()+" ,"+center.getY());
}

}
