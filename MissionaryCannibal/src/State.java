
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TASNEEA
 */
public class State {

    public int[] obj;

    public State() {
        obj = new int[7];
        obj[0] = obj[1] = obj[2] = obj[3] = obj[4] = obj[5] = obj[6] = 0;
    }

    public State(int mis1, int mis2, int mis3, int can1, int can2, int can3, int boat) {
        obj = new int[7];
        obj[0] = mis1;
        obj[1] = mis2;
        obj[2] = mis3;
        obj[3] = can1;
        obj[4] = can2;
        obj[5] = can3;
        obj[6] = boat;
    }

    public ArrayList<State> generateNextState() {
        ArrayList<State> ret = new ArrayList<>();
    //    State s1 = new State(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6]);
        if (obj[6] == 0) {
            for (int i = 0; i < 6; i++) {
                State s = new State(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6]);
                s.obj[6] = 1;
                if(s.obj[i]==0)   s.obj[i]=1;
                else continue;
                ret.add(s);
                //System.out.println("outer "+s.toString());
                for (int j = i + 1; j < 6; j++) {
                    State s2 = new State(s.obj[0], s.obj[1], s.obj[2], s.obj[3], s.obj[4], s.obj[5], s.obj[6]);
                    if(s2.obj[j]==0)   s2.obj[j]=1;
                    else continue;
                    ret.add(s2);
                    //System.out.println("inner "+s2.toString());
                }
            }
        }
        else{
            for (int i = 0; i < 6; i++) {
                State s = new State(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6]);
                s.obj[6] = 0;
                if(s.obj[i]==1)   s.obj[i]=0;
                else continue;
                ret.add(s);
                //System.out.println("outer "+s.toString());
                for (int j = i + 1; j < 6; j++) {
                    State s2 = new State(s.obj[0], s.obj[1], s.obj[2], s.obj[3], s.obj[4], s.obj[5], s.obj[6]);
                    if(s2.obj[j]==1)   s2.obj[j]=0;
                    else continue;
                    ret.add(s2);
                    //System.out.println("inner "+s2.toString());
                }
            }
        }
        
        return ret;
    }

    public boolean isIllegalState() {
        int miscnt0=0,miscnt1=0,cancnt0=0,cancnt1=0;
        for (int i = 0; i < 3; i++) {
            if(obj[i]==0)miscnt0++;
            else miscnt1++;
        }
        for (int i = 3; i <6; i++) {
            if(obj[i]==0)cancnt0++;
            else cancnt1++;
        }
        if((miscnt0<cancnt0 && miscnt0!=0) || (miscnt1<cancnt1 && miscnt1!=0))  return true; //miscnt0!=0 karon emon condition ase jekhane ek pare khali mis arek pare khali canns thakbe. tokhon can er shonkha 0 side e mis er theke beshi hobe kintu sheta valid state jehetu khaoar keu nai
        else return false;
    }

    @Override
    public String toString() {
        return "" + obj[0] + obj[1] + obj[2] + obj[3] + obj[4] + obj[5] + obj[6];
    }

    public int toInt(){
        int i = obj[0] + obj[1]*2 + obj[2]*4 + obj[3]*8 + obj[4]*16 + obj[5]*32 + obj[6]*64; 
        return i;
    }
}
