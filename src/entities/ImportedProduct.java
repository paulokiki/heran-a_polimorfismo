
package entities;


public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(Double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(Double customsFee, String name, Double price) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
     
    public double totalPrice(){
        return getPrice() + customsFee;
    }
    
    @Override
    public String priceTag() {
		return name 
				+ " $ " 
				+ String.format("%.2f", totalPrice());
	}
}
