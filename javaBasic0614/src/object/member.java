package object;

public class member {
	private int mid,count,price;
	private String[] name=new String[10];
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public void setName(int a,String name) {
	
		this.name[a] = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price += price;
	}
	public void setMinPrice(int price) {
		this.price += price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
}
