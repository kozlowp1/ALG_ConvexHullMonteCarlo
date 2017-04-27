package convexHull;

import java.util.ArrayList;
import java.util.Arrays;

import convexHull.Point;

public class Jarvis { 
	
	public static ArrayList<Point> temporaryList = new ArrayList<Point>();
	public static Point[] feedFromTempList;
	public static Point[] hullsReturn;
	public static int numbRetCells;
	
    private boolean CCW(Point O, Point A, Point B)
    {
        int val = (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
 
         if (val >= 0)
             return false;
         else
         return true;
    }
	
    

    public void convexHull(Point[] points)
    {
        int n = points.length;
        
        /** if less than 3 points return **/        
        if (n < 3) 
            return;     
        int[] next = new int[n];
        Arrays.fill(next, -1);
 
        /** znajduje punkt najbardziej wysuniety na lewo (punkt poczatkowy) **/
        int leftMost = 0;
        for (int i = 1; i < n; i++){
        	if (points[i].x < points[leftMost].x)
             leftMost = i;
        }

        /**
         * Na poaczatku dodajemy do p punkt poczatkowy, ale w nastepnych iteracjach
         * punkt ten sie zmieni na nastepny - poczatkowy dla wyszukania nastepnego punktu
         * 
         */
        int p = leftMost, q;
        /** itaruj zanim punkt odniesienia znow stanie sie punktem poczatkowym programu **/
        do
        {
        	//chcemy znalezc taka krawedz ze wszyskie inne punkty leza po jej prawej stronie
            q = (p + 1) % n;
            
            for (int i = 0; i < n; i++){
            	//iterujemy po pozostalych punktach i wyluskujemy ten "najbardziej po prawej"
            	/*
            	 * points[p], - ten od ktorego bedzie zaczynac sie bierzaca krawedz
            	 * points[i], - punkt iterowany w tablicy (bedzie szukany ten najbardziej spel. warunek)
            	 * points[q]  - odniesienie do 
            	 * 
            	 * 
            	 */
            	if (CCW(points[i],points[p], points[q])){
                 q = i;
                 }
            }
              
            //przypisanie wartosci do tablicy zawierajacej punkty na obwodzie otoczki
            next[p] = q;  
            p = q;
            //dane sa przesuniete o 1 ale to nie zrobi roznicy w przyszlych obliczeniach
            temporaryList.add(points[p]);
            System.out.println(points[p].x + " ; " + points[p].y);
            
        } while (p != leftMost);
        
        this.addSortedPoints(temporaryList);
        //this.addPoints(points, next);
    }
    
    
    /*
     * 
     * nowa zgrabniejsza wersja, punkty sa posortowane
     * co oznacza ze mozna z nich robic krzywe 
     * co sie przyda w Monte Carlo 
     */
    
    
    private void addSortedPoints(ArrayList<Point> sorted) {
        feedFromTempList = new Point[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
        	feedFromTempList[i] = sorted.get(i);
        }
		
	}


    /*
     * 
     * stara wersja dodawania - nie posortowane punkty
     */
	public void addPoints(Point[] points, int[] next)
    {	
    	int counter = 0;
        System.out.println("\nConvex Hull points : ");
        for (int i = 0; i < next.length; i++){
        	 if (next[i] != -1)
             //System.out.println("("+ points[i].x +", "+ points[i].y +")");
             counter++;
        }
        numbRetCells=counter;
        hullsReturn = new Point[counter];
        int cntrNT = 0;
        for (int i = 0; i < next.length; i++){
       	if (next[i] != -1){
        //System.out.println("("+ points[i].x +", "+ points[i].y +")");
       	hullsReturn[cntrNT] = points[i];
       	cntrNT++;
       	 }
       }
        		
    }
    
}
