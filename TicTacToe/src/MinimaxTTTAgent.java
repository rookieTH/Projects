
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TASNEEA
 */
public class MinimaxTTTAgent extends Agent {

    public int cutoff = 0;

    public MinimaxTTTAgent(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void makeMove(Game game) {
        //   TickTackToe tttGame = (TickTackToe) game;
        // TODO Auto-generated method stub

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TickTackToe tttGame = (TickTackToe) game; //AGER VAL JETA PACCHE AGE THEKE
        System.out.println("D");
        CellValueTuple best = max(tttGame, -1000, 1000); ///CUZ AI IS PLAYING AS MAX
        //CellValueTuple best = max(tttGame);
        if (best.col != -1) //OI COL E AGER -1 NAKI
        {
            tttGame.board[best.row][best.col] = 1;//= role;
        }

        //    TickTackToe tttGame = (TickTackToe) game;
        /*   System.out.println("Enter row and then col: ");
              Scanner in = new Scanner(System.in);
       
         int machinerow = in.nextInt();
        int machinecol= in.nextInt();    
         System.out.println("machine "+tttGame.isValidCell(machinerow,machinecol));
            while(tttGame.isValidCell(machinerow,machinecol)!=true){
              System.out.println("Enter row and then col: ");
       
                 machinerow = in.nextInt();
                 machinecol= in.nextInt();  
            }
            tttGame.board[machinerow][machinecol]=1;*/
    }

    private CellValueTuple max(TickTackToe game, int alpha, int beta)//IMPLEMENT
    {
        CellValueTuple maxCVT = new CellValueTuple();

        int compareUtility = -2;
        int tempState, flag = 0;
        if (game.isFinished()) {
          //  System.out.println("cutoff " + cutoff);
            if (game.checkForWin() == 1) {
                maxCVT.utility = 1;
            } else if (game.checkForWin() == -1) {
                maxCVT.utility = -1;
            } else {
                maxCVT.utility = 0;
            }
            return maxCVT;
        }
        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board.length; j++) {
                if (game.board[i][j] == -1) { //if board is empty
                    game.board[i][j] = 1;
                    compareUtility = min(game, alpha, beta).utility;

                    if (compareUtility > alpha) {
                        alpha = compareUtility;
                        maxCVT.utility = compareUtility;
                        maxCVT.row = i;
                        maxCVT.col = j;

                        if (alpha >= beta) {
                            cutoff++;
                            game.board[i][j] = -1;
                            flag = 1;
                            break;
                        }
                        
                    }
                    game.board[i][j] = -1;
                }

            } 
        }

        return maxCVT;

    }

    private CellValueTuple min(TickTackToe game, int alpha, int beta) {
        CellValueTuple minCVT = new CellValueTuple();

        int winner = game.checkForWin();
        int compareUtility = -2; 

        int tempState, flag = 0;
        if (game.isFinished()) {
//            System.out.println("cutoff " + cutoff);
//leaf check korte,termination e
            if (game.checkForWin() == 1) {
                minCVT.utility = 1;
            } else if (game.checkForWin() == -1) {
                minCVT.utility = -1;
            } else {
                minCVT.utility = 0;
            }

            return minCVT;
        }
        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board.length; j++) {
                if (game.board[i][j] == -1) {
                    game.board[i][j] = 0;
                    compareUtility = max(game, alpha, beta).utility;
                    if (minCVT.utility > compareUtility) {
                        minCVT.utility = compareUtility;
                        minCVT.row = i;
                        minCVT.col = j;
                    }
                    
                    if (compareUtility < beta) {
                        beta = compareUtility;
                        minCVT.utility = compareUtility;
                        minCVT.row = i;
                        minCVT.col = j;

                        if (alpha >= beta) {
                            cutoff++;
                            //game.board[i][j]=-1;
                            game.board[i][j] = -1; //cut 
                            flag = 1;
                            break;
                        }

                    }
                    game.board[i][j] = -1;

                }

            }
        }
        return minCVT;

    }

    private int minRole() {
        if (role == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private CellValueTuple max(TickTackToe game)//IMPLEMENT
    {
        CellValueTuple maxCVT = new CellValueTuple();
        int compareUtility = -2; //just for the sake of init
        //   TickTackToe tempGame = (TickTackToe) game;
        int tempState, flag = 0;
        int winner = game.checkForWin(); //NOT SAME AS THE WINNER BEFORE. EKHANE ETA INT
        if (game.isFinished()) { //leaf e jodi ashe
            if (game.checkForWin() == 1) {
                     maxCVT.utility = 1;
             
            } else if (game.checkForWin() == -1) {
                maxCVT.utility = -1;
               
            } else {
                maxCVT.utility = 0;
            }
            return maxCVT;
        }
        maxCVT.utility = -100;
        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board.length; j++) {
                if (game.board[i][j] == -1) { //khali thakle
                    game.board[i][j] = 1;
                    compareUtility = min(game).utility;
                    
                    if (maxCVT.utility < compareUtility) {
                        maxCVT.utility = compareUtility;
                        maxCVT.row = i;
                        maxCVT.col = j;
                    }
                   
                    game.board[i][j] = -1;
                }
            }
        }

        return maxCVT;

    }

    private CellValueTuple min(TickTackToe game) {
        CellValueTuple minCVT = new CellValueTuple();

        int winner = game.checkForWin();
        /////////  System.out.println("winner min " + winner);
        int compareUtility = -2; //just for the sake of init
        //   TickTackToe tempGame = (TickTackToe) game;
        int tempState, flag = 0;
        //Check if the terminating condition is fullfilled and return the object of CellValueTuple
        //implement max function of minimax/alpha-beta pruning algorithm
        if (game.isFinished()) { //leaf check korte,termination e
            if (game.checkForWin() == 1) {
                minCVT.utility = 1;
                //       System.out.println("***COMPUTER WINS***");
            } else if (game.checkForWin() == -1) {
                minCVT.utility = -1;
            } // System.out.println("***YOU WIN***");}
            else {
                minCVT.utility = 0;
                //System.out.println("***GAME DRAWN***");
            }

            return minCVT;
        }
        minCVT.utility = 100;
        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board.length; j++) {
                if (game.board[i][j] == -1) {
                    game.board[i][j] = 0;
                    compareUtility = max(game).utility;
                    flag = 1; //change korsi bujhate

                    if (minCVT.utility > compareUtility) {
                        minCVT.utility = compareUtility;
                        minCVT.row = i;
                        minCVT.col = j;
                    }
                    // if(flag==1){
                    game.board[i][j] = -1;
                } 
                // flag=0;
                // }

            }
        }
        return minCVT;

    }

    class CellValueTuple {

        int row, col, utility; //utility ta theke maybe tree er values gula pabo i.e 0,1,-1 AND ROW COL THEKE BEST POSN

        public CellValueTuple() {
            // TODO Auto-generated constructor stub
            row = -1;
            col = -1;
        }
    }

}
