/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author TASNEEA
 */

public class BFS {

	Queue<State> Q;
	HashSet<String> visited; //hashset er shubidha holo j duplicated bar add kore na ek jinish
        State [] parents;
	
	public BFS()
	{
                parents  = new State[200];
		Q = new LinkedList<>(); //cinf
		visited = new HashSet<>();
	}
	
	public void start(State start)
	{
            Q.add(start);
            visited.add(start.toString()); ///HashSet<String> visited; add kore jacche jeta visit kortese
            while (Q.size() != 0)
            {
                State u = Q.poll(); // u holo amar parent
                if (u.toString().equals("1111111"))
                        return;
                ArrayList<State> v_list =u.generateNextState(); //generate next state diye child gula ber kortesi
                for (State v : v_list)
                {
                    if (visited.contains(v.toString())) // baad dicchi cuz ekbar visited
                                continue;
                    if (v.isIllegalState())  ///illegal state
                            continue;

                    visited.add(v.toString()); //legal and not visited kono state jodi hoi tahole sheta add korbo visited e  
                    Q.add(v); ///next bar etar child niye kaj korbo, mane while e
                    parents[v.toInt()] = u; //oi child er parent ashole u, u diye call korei next state paisilam
                }
            }
	}
        
        public void printPath(){
            int st=127; ///last
            Stack <String> s = new Stack <String> ();
            while(st!=0){
                State p = parents[st];
                s.push(p.toString());
                st = p.toInt(); // khatai calculation korsi, ekta time e giye 0 hobe, first state er jonno arki
            }
            while(!s.empty())
            { 
                System.out.println(s.pop());
            }
            System.out.println("1111111"); // 111111 er parent pushed ase but eta pushed nai. ejonno eta alada kore print
        }
}
