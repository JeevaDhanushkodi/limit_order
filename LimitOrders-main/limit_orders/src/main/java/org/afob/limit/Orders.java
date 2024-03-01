package org.afob.limit;

import java.math.BigDecimal;

public class Orders {

	private  String buy;
    private  String productId;
    private  int amount;
    private  BigDecimal limit;

    public Orders(String buy, String productId, int amount, BigDecimal limit) {
        this.buy = buy;
        this.productId = productId;
        this.amount = amount;
        this.limit = limit;
    }

    public String isBuy() {
        return buy;
    }

    public String getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getLimit() {
        return limit;
    }
	
}
