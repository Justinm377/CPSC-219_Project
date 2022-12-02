package application;

public class Drinks extends MenuItem {
	private String size;
	
	public Drinks() {
		super();
	}
	
	public Drinks(int amountItem, double priceItem, String sizeDrink) {
		super(amountItem, priceItem);
		setSize(sizeDrink);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public double calculateDrinkTotalPrice() {
		if (getSize() == "Small") {
			
		} else if (getSize() == "Medium") {
			
		} else if (getSize() == "Large") {
			
		}
		
		return 0;
	}
}
