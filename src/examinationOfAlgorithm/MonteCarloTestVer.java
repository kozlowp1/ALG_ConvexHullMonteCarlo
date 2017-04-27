package examinationOfAlgorithm;

import convexHull.Point;


public class MonteCarloTestVer {
	/*
	 * 
	 * Additional set of Test variables
	 * 
	 */
	//tablica pierwszego wymiaru przechowuje ilosc wystrzelonych punktow
	//druga dane pomiarowe dla tychze punktow
	//

	public Measurement measurements;
	public int globalX;
	public double valVol;
	
	public double originalValue;
	
private  int countNot;
private  int counterOK;
private  int xmax;
private  int xmin;
private  int ymax;
private  int ymin;



public MonteCarloTestVer(Point[] hull) {
    this.findBorderPoints(hull);
}

private int calculateVolumeSquare(){
	int squareVolume=(ymax-ymin)*(xmax-xmin);
	//System.out.println("square of the rectangle: " + squareVolume);
	return squareVolume;
}


public double calculateVolumeFigure(){
	double volume;
	volume=((double)(counterOK)/(double)(countNot+counterOK))*(double)(calculateVolumeSquare());
	//System.out.println("square of the figure: " + volume);
	//System.out.println(volume);
	return volume;
	
}

private boolean onLeft(Point O, Point A, Point B)
{
    int val = (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);

     if (val > 0)
         return true;
     else
     return false;
}

//int x - ilosc punktow ktorymi strzelamy w prostokat
//Point[] points - punkty do wyrysowania krzywych
public void shotWithPoints(int x, Point[] points){
	//zbieranie punktow
	globalX=x;


	//Na przykład, gdy chcemy uzyskać liczbę z zakresu od 1 do 10,
	//int liczbaLosowa = (int) (Math.random() * 10 + 1);
	for(int i=0;i<x;i++) {
		boolean check=true;
		int randX = (int) (Math.random() * xmax + xmin);
		int randY = (int) (Math.random() * ymax + ymin);
		//System.out.println(" \r " + randX + ":" + randY );
		Point pointR=new Point(randX,randY);
		//sprawdzam czy znajduje sie po prawej stronie kazdej z krawedzi
				for(int p=0;p<points.length;p++){
					//int p - pierwszy punkt krawedzi
					int q;//drugi punkt krawedzi

					q = (p + 1) % points.length;

					if(!onLeft(pointR,points[p],points[q] )){
						check=false;
						break;
					}
				}
		if(check==true){
			countNot++;
		}
		else{
			counterOK++;
		}

	}
	valVol=calculateVolumeFigure();
	//System.out.println(valVol);
	//System.out.println("not ok: " + countNot + ";  OK: " + counterOK);
	//System.out.println(countNot + "    "  + counterOK );
}

public int[] findBorderPoints(Point[] points){	
	//krawedzie prostokatu
	xmax=points[0].x;
	xmin=points[0].x;
	ymax=points[0].y;
	ymin=points[0].y;

	for(int i=1;i<points.length;i++){
			//x max
			if(points[i].x>xmax){
				xmax=points[i].x;
			}
			//y max
			if(points[i].y>ymax){
				ymax=points[i].y;
			}
			//x min
			if(points[i].x<xmin){
				xmin=points[i].x;
			}
			//y min
			if(points[i].y<ymin){
				ymin=points[i].y;
			}
	}	

	int[] borderPoints=new int[4];
	borderPoints[0]=xmax;
	borderPoints[1]=ymax;	
	borderPoints[2]=xmin;	
	borderPoints[3]=ymin;
	/*
	System.out.println("\t \r \r skrajne punkty:");
	System.out.println("xmax " + xmax);
	System.out.println("ymax " + ymax);
	System.out.println("xmin " + xmin);
	System.out.println("ymin " + ymin);
	*/
	return borderPoints;
}




}
