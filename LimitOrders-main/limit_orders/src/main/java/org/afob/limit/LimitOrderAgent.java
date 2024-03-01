package org.afob.limit;

import java.math.BigDecimal;
import java.util.List;

import org.afob.execution.ExecutionClient;
import org.afob.execution.ExecutionClient.ExecutionException;
import org.afob.prices.PriceListener;

public class LimitOrderAgent implements PriceListener {
	
	public ExecutionClient ec;
    private final List<Orders> orders;


    public LimitOrderAgent(final ExecutionClient ec, List<Orders> orders) {
    	this.orders = orders;
		this.ec = ec;
    }

    @Override
    public void priceTick(String productId, BigDecimal price) {

    	BigDecimal bg = new BigDecimal("100");
    	
    	if(productId == "IBM" && price.compareTo(bg) < 1) {
    		try {
    			//buy or sell based on ordertype 
				ec.buy("IBM", 1000);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
    	}

    }


	public void addOrder(String action, String productId, int amount, BigDecimal limit) {

			 Orders order = new Orders(action, productId, amount, limit);
			 orders.add(order);
	}

}
