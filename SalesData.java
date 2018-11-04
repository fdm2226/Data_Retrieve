package Project3;

public class SalesData {

	private int ProductId;
	private int CustomerId;
	private int Units;
	
public SalesData(int cI, int pI, int u){
		
		CustomerId = cI;
		ProductId = pI;
		Units = u;
		
	}
	
	public int getProductId(){
		return this.ProductId;
		
	}
	
	public void setProductId(int productInput){
		this.ProductId = productInput;
	}
	
	public int getCustomerId(){
		return this.CustomerId;
	}
	
	public void setCustomerId(int inputCustomerId){
		this.CustomerId = inputCustomerId;
		
	}
	
	public int getUnits(){
		return this.Units;
	}
	
	public void setUnits(int inputUnits){
		this.Units = inputUnits;
	}
	
	
	//method
			public String toString(){
				return "Product Id: " + this.ProductId + " CustomerId: " + this.CustomerId + " Units: " + this.Units;
						
					}
	
}
