package javaBasic0618;

public class memberDTO {
private String name;
private String job;
private int age,id;
private  String message ="�޼����� �����ϴ�.";
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String gender;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

}
