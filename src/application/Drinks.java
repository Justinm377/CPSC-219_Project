package application;

public class Drinks extends MenuItem {
	private String size;
	
	public Drinks() {
		super(); //idk if we need this???
	}
	
	public Drinks(String drinkSize, String drinkAmount) {
		setSize(drinkSize);
		setAmount(Integer.parseInt(drinkAmount));
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public double calculateDrinkTotalPrice() {
		if (getSize().equals("Small")) {
			setPrice(1.99);
		} else if (getSize().equals("Medium")) {
			setPrice(2.49);
		} else if (getSize().equals("Large")) {
			setPrice(2.99);
		}
		
		return calculateItemTotalPrice();
	}

}