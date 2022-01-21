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


public class FirstChoiceHillClimb 
{
	TSP tsp;
	int sigma;
	
	public FirstChoiceHillClimb(TSP tsp, int sigma) 
	{
		// TODO Auto-generated constructor stub
		this.tsp = tsp;
		this.sigma = sigma;
	}
	
	/**
	 * Main loop of your local search algorithm. 
	 * After the search is complete, create a SolutionInfo Object 
	 * with related information and return to the caller to generate aggregated results
	 * @return
	 */
	public SolutionInfo run() 
	{
		//Main loop of your local search algorithm. 
		
                 Route currentRoute = new Route(this.tsp);
                 Route newRoute = new Route(this.tsp);  //new take just initialize korte ager route e use kortesi
                 int count=0,i;
             
                 double random;
                 while(true){
                 random= Math.random();
                 for (i = 0; i < this.sigma; i++) {
                        random= Math.random();
             if(random<0.50){
          newRoute = ZeroOneExchange.apply(currentRoute);
         System.out.println("new_route_cost_0_1_ex ");//+newRoute.getCost());*/
        //newRoute = Two_Opt.apply(currentRoute);
             }
               else {               
           newRoute = Two_Opt.apply(currentRoute);
            System.out.println("new_route_cost_2_opt ");
               }
           if(newRoute.cost<currentRoute.cost){currentRoute = newRoute ;
              /* System.out.println("better");*/
           count++ ;
           break;
           }
                 }
               if(i==sigma){
                    System.out.println("COUNT " +count);
                  break;
           
               }
                    }
               SolutionInfo solInfo = new SolutionInfo(currentRoute,count);
                return solInfo;
            }
      
                     
        }


	
        




	
	
	
