package K;

import java.io.Serializable;

public class Good implements Serializable {

	String name;
	String price;
	String type;
	String introduce;
	
	public Good(String name,String price,String type,String introduce) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.price=price;
		this.type=type;
		this.introduce=introduce;
		
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
		
		
	}
}
