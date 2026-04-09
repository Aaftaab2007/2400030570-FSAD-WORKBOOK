package model;

public class Person {
	String name;
	int age;
	String emailid;
	public Person(String name,int age,String emailid)
	{
		this.name=name;
		this.age=age;
		this.emailid=emailid;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getEmailid()
	{
		return this.emailid;
	}
}