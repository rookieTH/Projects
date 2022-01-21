/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */
import java.util.Random;


public class ZeroOneExchange 
{
	private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
		
		Route route = new Route (rt);
                int sz = route.n; //size of route
                //  int randomNum = rand.nextInt((max - min) + 1) + min;
                int ran1= + (int)(Math.random() * ((sz-1) + 0)); //integer betn 1 and n nicchi according to the algo
                int ran2=ran1; //equal hole loop ghurtei thakbe
                while(true){
                    ran2 =  + (int)(Math.random() * ((sz - 2) + 0));
                    if(ran2!=ran1){break;}
                    else continue;
                
                }
              int removed =  route.route.remove(ran1);
              //ran2 te dhukabo
              route.route.add(ran2,removed); //ran2 index e removed val ta boshacchi
		route.updateCost();
		return route;
	}
}
