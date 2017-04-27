package examinationOfAlgorithm;

import monteCarlo.MonteCarlo;
import convexHull.Point;

public class Test {

	/*Testujemy zwykle obliczanie pola/Sprawdzamy wplyw ilosci iteracji na dokladnosc
	 * 
	 * hull - punkty wszystkie
	 *hullsSortedReturn - te punkty ktore tworza 
	 * 
	 */
	public void testOfVolume(int numbOfSteps, Point[] hullsSortedReturn){
		//System.out.println("\r");
		for(int i=0;i<numbOfSteps;i++){
		 MonteCarlo montecarlo=new MonteCarlo(hullsSortedReturn);
	       montecarlo.shotWithPoints(10000,hullsSortedReturn);		
	       montecarlo.calculateVolumeFigure();
		}
	}
	
	/*
	 * 
	 * Sprawdzamy wplyw ilosci iteracji na dokladnosc
	 * 
	 */
	public void testOfAvgValue1(int shots,int numbOfSteps, Point[] hullsSortedReturn){
		//System.out.println("\r");
		Measurement measur = new Measurement(numbOfSteps);
		//zakladamy ze wartoscia do ktorej bedziemy porownywac inne (i blad)
		//bedzie ta ktora bedzie wynikala z najwiekszej ilosci iteracji
		for(int i=0;i<numbOfSteps;i++){
			MonteCarloTestVer montecarloTestVer=new MonteCarloTestVer(hullsSortedReturn);
			 montecarloTestVer.shotWithPoints(shots,hullsSortedReturn);		
			 montecarloTestVer.calculateVolumeFigure();
			 measur.setOfMeas[i]=montecarloTestVer.valVol;

			}
		
		/*//sprawdzenie zawartosci tablicy
		for(int i=0;i<numbOfSteps;i++){
			System.out.println(measur.setOfMeas[i]); 

			}*/
		//System.out.println("\r");
		System.out.println(shots + "	" + numbOfSteps + "		" + findingAverageVal(measur.setOfMeas,numbOfSteps));
		
	}
	
	
	public void testOfAvgValue2(int samples,int shots, Point[] hullsSortedReturn){
		//System.out.println("\r");
		Measurement measur = new Measurement(samples);
		//zakladamy ze wartoscia do ktorej bedziemy porownywac inne (i blad)
		//bedzie ta ktora bedzie wynikala z najwiekszej ilosci iteracji
		for(int i=0;i<samples;i++){
			MonteCarloTestVer montecarloTestVer=new MonteCarloTestVer(hullsSortedReturn);
			 montecarloTestVer.shotWithPoints(shots,hullsSortedReturn);		
			 montecarloTestVer.calculateVolumeFigure();
			 measur.setOfMeas[i]=montecarloTestVer.valVol;

			}
		
		/*//sprawdzenie zawartosci tablicy
		for(int i=0;i<numbOfSteps;i++){
			System.out.println(measur.setOfMeas[i]); 

			}*/
		//System.out.println("\r");
		System.out.println(shots + "	" + samples + "		" + findingAverageVal(measur.setOfMeas,samples));
		
	}
	
	
	private double findingAverageVal(double[] setOfVolumeMeasurements, int globalX){
		double sum = 0;
		double average;
		for (double d : setOfVolumeMeasurements) sum += d;
		average=((sum)/globalX);
		return average;
		
	}
	
	/*
	 * shots
	 * max
	 * jump
	 * array of curves
	 */
	public void testOfIteration(int mode,int shots_samples, int max,int jump,Point[] hullsSortedReturn){
		//sprawdzamy probkowanie
		if(mode==1){
		for(int k=0;k<max;k=k+jump){
			this.testOfAvgValue1(shots_samples,k,hullsSortedReturn);
		}
		}
		//sprawdzamy ilosc punktow
		else if(mode==2){
			for(int k=0;k<max;k=k+jump){
				this.testOfAvgValue2(shots_samples,k,hullsSortedReturn);
			}
		}
		else{
			System.out.println("zly tryb");
		}
	}
	
	
}
