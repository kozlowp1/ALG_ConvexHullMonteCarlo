package examinationOfAlgorithm;

public class Measurement extends Test{
private double measError;
private double avValueOfMeas;
public double[] setOfMeas;




public Measurement(int numbOfSteps) {
	setOfMeas=new double[numbOfSteps];
}


public double getMeasError() {
	return measError;
}

public void setMeasError(double measError) {
	this.measError = measError;
}

public double getAvValueOfMeas() {
	return avValueOfMeas;
}

public void setAvValueOfMeas(double avValueOfMeas) {
	this.avValueOfMeas = avValueOfMeas;
}

public double[] getSetOfMeas() {
	return setOfMeas;
}

public void setSetOfMeas(double[] setOfMeas) {
	this.setOfMeas = setOfMeas;
}
/*
private void calculateError(){
	
}

private void calcAvValue(){
	
}
*/
}
