package Run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import monteCarlo.MonteCarlo;
import convexHull.Jarvis;
import convexHull.Point;
import examinationOfAlgorithm.Test;

public class Run {
	/** Main function 
	 * @throws IOException **/
    public static void main (String[] args) throws IOException 
    {
    	// ------------------------------------wyodrebnienie punktow dla otoczki --------------------------
        Scanner scan = new Scanner(System.in);
        System.out.println("Jarvis Algorithm Test\n");
        /** stworzenie obiektu klasy Jarvis **/
        Jarvis jarv = new Jarvis();        
 
		BufferedReader f = new BufferedReader(new FileReader("data.txt")); 	// "data.txt"  => size x y x y x y x y
		StringTokenizer st = new StringTokenizer(f.readLine());
		Point[] inputPoints = new Point[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < inputPoints.length; i++) {
			inputPoints[i] = new Point();
			inputPoints[i].setX(Integer.parseInt(st.nextToken()));
			 // Read X coordinate 
			inputPoints[i].setY(Integer.parseInt(st.nextToken()));
			 // Read y coordinate
		}
		for(int y=0;y<inputPoints.length;y++){
			System.out.println(inputPoints[y].x + " " + inputPoints[y].y);
		}
		
        
		Jarvis jarvis = new Jarvis();
		jarvis.convexHull(inputPoints);
		
		Point[] hull = new Point[jarvis.feedFromTempList.length];
		
		
		for(int g=0;g<jarvis.feedFromTempList.length;g++){
			hull[g]=jarvis.feedFromTempList[g];}
		
		
		for (int i = 0; i < hull.length; i++) {
			if (hull[i] != null)
				System.out.print(hull[i].x + " " + hull[i].y + " ; ");
		}
		
        //----------------------------------------------------------------------------------------     
		Test test = new Test();
		/* mode 1 - sampling mode | 2 - shot mode
		 * shots in sampling mode |  sampling in shot mode
		 * max 
		 * jump
		 * array of curves
		 */
		//
		test.testOfIteration(2,1,5000,10,jarvis.feedFromTempList);
		/**
		 * Result
		 * shots | samples | avg. val. of volume
		 * 1000|500|31.628339999999962
		 */
    }
}
