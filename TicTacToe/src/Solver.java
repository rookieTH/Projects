/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */
public class Solver {
	
	/*
	 * The starting point of the game.
	 * Instantiates two agents (human/ minimax/ alpha beta pruning/ or other) and pass them to a game object.
	 */
	
	public static void main(String[] args) 
	{
		Agent human = new HumanTTTAgent("YOU");
         	Agent machine = new MinimaxTTTAgent("Computer");
           	Game game = new TickTackToe(human,machine);
		game.play();
		
	}

}
