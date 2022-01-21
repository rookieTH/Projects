
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */


public class two_opt_ran
{

	/**
	 * improves the route by repeatedly applying the first better 2-opt move
	 * @param individual
	 * @param period
	 * @param vehicle
	 * @return false if cost is not decreased
 	 */
	public static Route apply(Route rt)
	{
            Random random = new Random();
             Route routeObject = new Route(rt);
             Route newroute = new Route(rt);
             newroute.route.clear();
             int n = rt.n;
             //randomNumber = random.nextInt(max + 1 - min) + min;
          //  int ran1 =  (int)(Math.random() *(((n-1)- 1) + 1) + 1);
            //int ran2=ran1;
           //while(ran2<=ran1){
             int ran1 = random.nextInt((n-1) + 1 - 0)+0;
             int ran2 = random.nextInt((n-1)+1 - ran1)+ran1;
           //  System.out.println("ran1 " + ran1 + "ran2  "+ ran2);
        //////////////////    ran2=(int)(Math.random() *(((n-1)- ran1) + ran1) + 1);
          ///   System.out.println("dhuke " + ran2);
          //  }
          //  twoOptSwap(rt,random1,random2);
           for (int i = 0; i < ran1; i++) {
             newroute.route.add(routeObject.route.get(i)); 
         }
          ArrayList<Integer>out1 = new ArrayList<Integer> (routeObject.route.subList(ran1,ran2 + 1)); 
        Collections.reverse(out1);
        int k = 0;
         for(int j=ran1;j<=ran2;j++){
              newroute.route.add(out1.get(k));
          k++;
          }
          for(int i = ran2 + 1 ; i<routeObject.route.size();i++){
          newroute.route.add(routeObject.route.get(i));
          }
           
            System.out.println("new_route_cost_2_opt "+newroute.getCost());
            /////
            newroute.updateCost();
		return newroute;
	}
	
	public static Route twoOptSwap(Route routeobject, int i, int k) 
	{
	Route twoOptRoute =  new Route(routeobject);
    
        return twoOptRoute;
	}
	
}


