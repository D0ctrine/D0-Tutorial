package Object;

import java.util.ArrayList;

public class Member {
private String id=null;
private String name=null;
private ArrayList<Goods> myBasket = new ArrayList<>();
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<Goods> getMyBasket() {
	return myBasket;
}
public void setMyBasket(ArrayList<Goods> myBasket) {
	this.myBasket = myBasket;
}
}
