/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Route 
{
	ArrayList<Integer> route; //index ase
	int n;
	double cost;
	TSP tsp;
	
	/**
	 * Initialize a new route and update its cost
	 * @param tsp
	 */
	public Route(TSP tsp) {
		// TODO Auto-generated constructor stub
		this.n = tsp.n;
		this.tsp = tsp;
		route = new ArrayList<Integer>();
		
		initialize();
		updateCost();
	}
     
	/**
	 * Initialize a route with another route, makes a copy.
	 * @param src
	 */
	public Route(Route src)
	{
		this.n = src.n;
		this.tsp = src.tsp;
		
		route = new ArrayList<Integer>();
		
		for (Iterator iterator = src.route.iterator(); iterator.hasNext();) {
			route.add((Integer)iterator.next());
		}
		this.cost = updateCost();
	}
	
	
	/**
	 * Initializes a solution/route with a random permutation
	 */
	public void initialize() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			route.add(i);
		}
		
		Collections.shuffle(route);
                System.out.println("init route");
               
              
	}
	
	/**
	 * Prints the route
	 */
	
	public void print() 
	{
            System.out.println("ROUTE ");
		for (Iterator iterator = route.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Updates the member variable cost with the route length and also returns it. 
	 * @return
	 */
	public double updateCost()
	{
            double c = 0;
            for (int i = 0; i <(n-1); i++) {
              // route.get(i);
              c+=tsp.edgeCost(route.get(i),route.get(i+1));
                
            }
            c+=tsp.edgeCost(route.get(n-1),route.get(0));
            cost=c;
            return c;
	}

	public double getCost() {
		return cost;
	}

}
