package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SingleMenu extends Product {
	public SingleMenu(String productName, int price,int amount,int productId) {
		super(productName, price, 1,amount,productId);
	}


	
}
