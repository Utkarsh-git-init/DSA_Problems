package Strivers_dsa.Greedy;

public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills){
        int count5=0,count10=0,count20=0;
        for(int i:bills){
            switch (i){
                case 5:
                    count5++;
                    break;
                case 10:
                    if(count5<1)
                        return false;
                    count5--;count10++;
                    break;
                case 20:
                    count20++;
                    if(count10>0){
                        if(count5>0){
                            count5--;count10--;
                        }else
                            return false;
                    }else if(count5>=3)
                        count5-=3;
                    else
                        return false;
            }
        }
        return true;
    }
}
