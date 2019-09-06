package com.fahim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogicalOperations {
@Value("#{200>100}")
private boolean greateValue;

@Value("#{200<100}")
private boolean lesserValue;

@Value("#{200==200}")
private boolean equalValue;

@Value("#{10 > 18 ? true : false}")
private boolean isVoterValid;

public boolean isGreateValue() {
	return greateValue;
}

public void setGreateValue(boolean greateValue) {
	this.greateValue = greateValue;
}

public boolean isLesserValue() {
	return lesserValue;
}

public void setLesserValue(boolean lesserValue) {
	this.lesserValue = lesserValue;
}

public boolean isEqualValue() {
	return equalValue;
}

public void setEqualValue(boolean equalValue) {
	this.equalValue = equalValue;
}

public boolean isVoterValid() {
	return isVoterValid;
}

public void setVoterValid(boolean isVoterValid) {
	this.isVoterValid = isVoterValid;
}

@Override
public String toString() {
	return "LogicalOperations [greateValue=" + greateValue + ", lesserValue=" + lesserValue + ", equalValue="
			+ equalValue + ", isVoterValid=" + isVoterValid + "]";
}



}
