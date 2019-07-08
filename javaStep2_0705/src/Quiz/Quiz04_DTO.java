package Quiz;

public class Quiz04_DTO {

	private int point;
	private char bonus;
	private String option="";
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public char getBonus() {
		return bonus;
	}
	public void setBonus(char bonus) {
		this.bonus = bonus;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option += option;
	}
		
}
