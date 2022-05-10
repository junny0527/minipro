package com.javaex.phonebook;

public class PhoneDb {

	private int num;
	private String name;
	private String hp;
	private String company;

	public PhoneDb() {
		super();
	}

	public PhoneDb( String name, String hp, String company) {
		super();
		
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void showInfo() {
		System.out.printf("%d. %s\t%s\t%s", num, name, hp, company);
	}

	@Override
	public String toString() {
		String result = String.format("%d. %s\t%s\t%s", num, name, hp, company);
		return result;
	}

}
