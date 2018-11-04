package Project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import project1.Product;


public class InventorySystem {

	//global variable
	private String salesPath = "C:/Users/Owner/Desktop/Comp182/Comp182Project_3/Sales Data.csv";
	private String inventoryPath = "C:/Users/Owner/Desktop/Comp182/Comp182Project_3/Inventory Data.csv";
	private String productPath = "C:/Users/Owner/Desktop/Comp182/Comp182Project_3/Product Data.csv";
	
	
	private ArrayList<SalesData> salesData;
	private ArrayList<InventoryData> inventoryData;
	private ArrayList<ProductData> productData;
	
	
	
	//call methods
	public  InventorySystem(){
		salesData = new ArrayList<SalesData>();
		inventoryData = new ArrayList<InventoryData>();
		productData = new ArrayList<ProductData>();
		
		readSalesData(salesPath);
		readInventoryData(inventoryPath);
		readProductData(productPath);
		
		saleDataOutPut();
		invinOut();
			
		

	}
	
	//read SalesData
	private void readSalesData(String path){
		
		String line = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			br.readLine();
			while((line = br.readLine()) != null){
				String[] data  = line.split(",");
					if(data.length != 0){
					this.salesData.add(new SalesData(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
					}
					}//end of while loop
				br.close();
			}
			catch(Exception e){
				
	}
	}
	//end of read sales data
	
	
	private void readInventoryData(String path){
		String line = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			br.readLine();
			while((line = br.readLine()) != null){
				String[] data = line.split(",");
				if(data.length != 0){
					this.inventoryData.add(new InventoryData(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
				}
				}//end of while loop
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();

	}
	}
	
	private void readProductData(String path){
		String line = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			br.readLine();
			while((line = br.readLine()) != null){
				String[] data = line.split(",");
				if(data.length != 0){
					this.productData.add(new ProductData(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2].substring(1))));
				}
				}//end of while loop
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();

	}
	}
	
	
	public void saleDataOutPut(){
		int current = 1;
		String temp = "";
		System.out.println("Sales Data: ");
		for(int s = 0; s < salesData.size(); s++){
			if(current == this.salesData.get(s).getCustomerId()){
				temp += "CustomerID: " + salesData.get(s).getCustomerId() + "\n " + this.salesData.get(s).getProductId() + " ";
				ProductData currentProduct = findProduct(salesData.get(s).getProductId());
				if(currentProduct != null){
				temp += currentProduct.getDescription()+ " price: " + currentProduct.getPrice() + " units: "+ salesData.get(s).getUnits() + " total: " + (salesData.get(s).getUnits() * currentProduct.getPrice()) +  "\n";
				} 
			}
			else{
				current++;
				s--;
			}//end 
		}//end
		
		System.out.println(temp);
		}
	

private ProductData findProduct(int id){
	

	for(int i = 0; i < productData.size();i++){
		

		if(productData.get(i).getProductID() == id){
			
			return productData.get(i);
		}
	}
	return null;
}

public void invinOut(){
	String invent = "";
	int remainder;
	System.out.println("Inventory Data: ");
	for(int x = 0; x < inventoryData.size(); x++){
	    System.out.println("ProductId: " + inventoryData.get(x).getproductID() + " Starting Inventory: " + inventoryData.get(x).getStartInventory());

		//this part compares the product Id
			ArrayList<SalesData> temp = finder(inventoryData.get(x).getproductID());
        	for(int j = 0; j < temp.size();j++){
        		
        		inventoryData.get(x).setStartInventory(inventoryData.get(x).getStartInventory() - temp.get(j).getUnits());

        		
        		int[] uL = {inventoryData.get(x).getStartInventory()};
        		List<Integer> unitsLeft = new LinkedList<Integer>();
        		for(int i : uL)
        			unitsLeft.add(i);
        			
        		 	invent += "Inventory remainding: " + unitsLeft +  "\n";

		}
		

	}
	System.out.println(invent);
	
}//end

public ArrayList<SalesData> finder(int id){
	ArrayList<SalesData> temp = new ArrayList<SalesData>();
	for(int i = 0; i < salesData.size();i++){
		if(salesData.get(i).getProductId() == id){
			temp.add(salesData.get(i));

		}
		
	}
	return temp;
}




	
	public static void main(String[] args){
		new InventorySystem();
}



	
	
}
