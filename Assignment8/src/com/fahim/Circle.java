package com.fahim;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Circle implements Shapes {
	private Point center;

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Center: " +center.getX()+" ,"+center.getY());
	}

	@PostConstruct
	public void initCircle() {
		System.out.println("init method by annotation for Circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("init method by annotation for Circle");
	}
}
