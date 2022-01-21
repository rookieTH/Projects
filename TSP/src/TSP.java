/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TSP 
{
	double x[], y[];// coordinates
	int n; //no of cities

	public TSP(double x[], double y[], int n) 
	{
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.n = n;

	}
	
	private void solve() {
		// TODO Auto-generated method stub
		Route route = new Route(this);
                //System.out.println("cost"+route.updateCost());
             // System.out.println("ekdom starting");
		route.print();
                FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this, 10000);
		SolutionInfo si = fchc.run();
                System.out.println("soln cost");
		System.out.println(si.solution.getCost());
                System.out.println("soln");
		si.solution.print();
                
	}
	void print()
	{
		System.out.println("Dimension: "+n);
		for (int i = 0; i < n-1; i++) {
			System.out.println(x[i] + " " + y[i]);//+ "  "+this.edgeCost(i,i+1));
                        
		}
	}
	
	/**
	 * Returns the distance between the node a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public double edgeCost(int a, int b)
	{
		double x1 = this.x[a] - this.x[b];
                double y1 = this.y[a] - this.y[b];
                
                double ec= Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
                //System.out.println(ec);
                return ec;
               
	}
	
	public static void main(String[] args)
	{
		try 
		{
                        //  Scanner in = new Scanner(new File("src/test.tsp"));
			//Scanner in = new Scanner(new File("src/att48.tsp"));
			//Scanner in = new Scanner(new File("src/burma14.tsp"));
			//Scanner in = new Scanner(new File("src/st70.tsp"));
			//Scanner in = new Scanner(new File("src/ulysses16.tsp"));
			Scanner in = new Scanner(new File("src/ulysses22.tsp"));
			
			String line = "";
			int n;
			
			//three comment lines
			in.nextLine();
			in.nextLine();
			in.nextLine();
			//get n
			line = in.nextLine();
			line = line.substring(11).trim();
			n = Integer.parseInt(line);
			
			//System.out.println("" +n);
			
			//two comment lines
			in.nextLine();
			in.nextLine();
			
			double x[] = new double[n];
			double y[] = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				in.nextInt();
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
                   	TSP tsp = new TSP (x,y,n); //ekhane tsp object ta banacche
			tsp.print();
                        tsp.solve();
                        
                       // }
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
