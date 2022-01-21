/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TASNEEA
 */
import java.util.Scanner;

public class HumanTTTAgent extends Agent {

    static Scanner in = new Scanner(System.in);

    public HumanTTTAgent(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void makeMove(Game game) {

        TickTackToe tttGame = (TickTackToe) game;
        //   tttGame.board[0][0]=0;
        /*Human Agent will give his move;
                 if the move is not is a valid position (use the isValidCell(row, col) function of TickTackToe object) 
                            it will again ask for move otherwise play will be contunied*/
        ///INPUT NIBE FROM USER AND VALIDITY CHECK KORE ABAR PROMPT KORBE 
        ///TIC TAC TOE ER VALIDITY ER FUNCTION CALL KORTE HOBE, AGER THEKE NICCHI SO THAT I CAN KNOW KOTHAI KONTA FILLED
        System.out.println("Enter row and then col: ");
        Scanner in = new Scanner(System.in);

        int humanrow = in.nextInt();
        int humancol = in.nextInt();
        System.out.println("human " + tttGame.isValidCell(humanrow, humancol));
        if (humanrow >= 3 || humancol >= 3) {
            System.out.println("Enter both values again(should be less than 3)");
            humanrow = in.nextInt();
            humancol = in.nextInt();
        }
        while (tttGame.isValidCell(humanrow, humancol) != true) { //less than 3 ta rakhtesi naile bhul dile out of bound exception ashe -_-
            System.out.println("Enter row and then col: ");

            humanrow = in.nextInt();
            humancol = in.nextInt();
            if (humanrow >= 3 || humancol >= 3) {
                System.out.println("Enter both values again(should be less than 3)");
                humanrow = in.nextInt();
                humancol = in.nextInt();
            }
        }
        tttGame.board[humanrow][humancol] = 0;

    }

}
