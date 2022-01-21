/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Two_Opt 
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
         
            int flag=0;
            for(int i=1;i<n-1;i++)
            {
                for(int j = i+1; j<n; j++)
                {
                        newroute = twoOptSwap(routeObject,i,j); //i shobshomoi less than j e thaktese jeta sublist er jonno lagbe
                        //  newroute.updateCost();
                          if(newroute.getCost()<routeObject.getCost())
                          {
                                routeObject=newroute;
                         //     nr = new Route(newroute);  
                             // return nr;
                              flag=1;
                                break;
                          }
                }
                if(flag==1)break;
            }
           // newroute.updateCost();
        //   if(flag==1)return nr;
          // else
     /*      System.out.println("two opt route");
            for (int i = 0; i < routeObject.route.size(); i++) {
                System.out.print(routeObject.route.get(i)+ " ");
                
            }
            System.out.println("");*/
		return  routeObject;
	}
	
	public static Route twoOptSwap(Route routeobject, int l, int m) 
	{
	Route routeObject =  new Route(routeobject);
        Route newroute = new Route(routeobject);
        newroute.route.clear();
         for (int i = 0; i <l; i++) {
             newroute.route.add(routeObject.route.get(i)); 
         }
         ArrayList<Integer>out1 = new ArrayList<Integer> (routeObject.route.subList(l,m+ 1));
    
        Collections.reverse(out1);
        int k = 0;
         for(int j=l;j<=m;j++){
              newroute.route.add(out1.get(k));
          k++;
          }
          for(int i = m + 1 ; i<routeObject.route.size();i++){
          newroute.route.add(routeObject.route.get(i));
          }
         newroute.updateCost();
    
        return newroute;
	}
	
}
