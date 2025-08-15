package Strivers_dsa;

public class stock_121 {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
            return 0;
        int prof=0,min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                if(prof<prices[i]-min)
                    prof=prices[i]-min;
            }
            else
                min=prices[i];
        }
        return prof;
    }
}
