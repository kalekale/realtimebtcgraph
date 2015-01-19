
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public class Statistics {
    
    private MarketClient client;
    private int updateInterval;
    
    public Statistics(MarketClient client, int updateInterval) {
        this.client = client;
        this.updateInterval = updateInterval * 1000000;
    }
    
    public double highest(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        double highest = 0;
        for (Trade t : trades) {
            if (t.getPrice() > highest) {
                highest = t.getPrice();
            }
        }
        return highest;
    }
    
    public double lowest(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        double lowest = Integer.MAX_VALUE;
        for (Trade t : trades) {
            if (t.getPrice() < lowest) {
                lowest = t.getPrice();
            }
        }
        return lowest;
    }
    
    public double open(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        long firstDate = Long.MAX_VALUE;
        double open = 0;
        for (Trade t : trades) {
            if (t.getDate() < firstDate) {
                open = t.getPrice();
            }
        }
        return open;
    }
    
    public double close(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        long firstDate = 0;
        double close = 0;
        for (Trade t : trades) {
            if (t.getDate() > firstDate) {
                close = t.getPrice();
            }
        }
        return close;
    }
    
    
}
