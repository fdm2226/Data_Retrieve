package Project3;

public class InventoryData {

	private int ProductId;
	private int StartingInventory;
	
	
	public InventoryData(int pI, int sT){
		ProductId = pI;
		StartingInventory = sT;
	}
	
	public int getproductID(){
		return this.ProductId;
	}
	
	public void setproductID(int productInput){
		this.ProductId = productInput;
	}
	
	public int getStartInventory(){
		return this.StartingInventory;
	}
	
	public void setStartInventory(int inventoryInput){
		this.StartingInventory = inventoryInput;
	}
	
	public String toString(){
		return " Product Id: " + this.ProductId + " Starting Inventory: " + this.StartingInventory;
				
			}
	
}
