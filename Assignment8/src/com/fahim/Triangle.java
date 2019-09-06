package com.fahim;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware,Shapes {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
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
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = context;	
	}

	public void myInit() {
		System.out.println("init method by xml config for Triangle");
	}

	public void cleanUp() {
		System.out.println("cleanUp method by xml config for Triangle");
	}


	@Override
	public void setBeanName(String beanName) {
		System.out.println("BeanName is : "+beanName);	
	}
}
