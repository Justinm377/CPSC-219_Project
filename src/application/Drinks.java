package application;

public class Drinks extends MenuItem {
	private String size;
	
	public Drinks() {
		super();
	}
	
	public Drinks(String drinkSize) {
		setSize(drinkSize);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public double calculateDrinkTotalPrice() {
		if (getSize() == "Small") {
			setPrice(1.99);
		} else if (getSize() == "Medium") {
			setPrice(2.49);
		} else if (getSize() == "Large") {
			setPrice(2.99);
		}
		
		
		
		//System.out.print(calculateItemTotalPrice());
		
		return calculateItemTotalPrice();
	}
}
