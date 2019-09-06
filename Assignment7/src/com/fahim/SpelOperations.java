package com.fahim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpelOperations {
@Value("#{2+3}")
private int addValue;

@Value("#{5-3}")
private int subValue;

@Value("#{10/3}")
private int divideValue;

@Value("#{10*3}")
private int mulValue;

@Value("#{13%3}")
private int modValue;

@Override
public String toString() {
	return "SpelOperations [addValue=" + addValue + ", subValue=" + subValue + ", divideValue=" + divideValue
			+ ", mulValue=" + mulValue + ", modValue=" + modValue + "]";
}

public int getAddValue() {
	return addValue;
}

public void setAddValue(int addValue) {
	this.addValue = addValue;
}

public int getSubValue() {
	return subValue;
}

public void setSubValue(int subValue) {
	this.subValue = subValue;
}

public int getDivideValue() {
	return divideValue;
}

public void setDivideValue(int divideValue) {
	this.divideValue = divideValue;
}

public int getMulValue() {
	return mulValue;
}

public void setMulValue(int mulValue) {
	this.mulValue = mulValue;
}

public int getModValue() {
	return modValue;
}

public void setModValue(int modValue) {
	this.modValue = modValue;
}

}
