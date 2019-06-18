package Table;

public class OneMenuInfo {
	private int OneMenuFlag = -1;
	private String menuName = null;
	private int cnt=0;
	private int menuPrice = 0;
	private int tableNum = 0;
	
	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public void prt() {
		System.out.println("주문하신 메뉴 번호 :"+OneMenuFlag);
		System.out.println("주문하신 메뉴 이름 :"+menuName);
		System.out.println("주문하신 메뉴 가격 :"+menuPrice);
		System.out.println("주문하신 메뉴 수량 :"+cnt);
	}
	
	public int getOneMenuFlag() {
		return OneMenuFlag;
	}
	public void setOneMenuFlag(int oneMenuFlag) {
		OneMenuFlag = oneMenuFlag;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
}
