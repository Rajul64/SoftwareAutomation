package encapsulation;

public class MyPrivateClass {
	
	private String str = "My new string"; //class level variable
	
	public String getstr()
	{
		return str;  // 1st time print
	}
	
	public void setstr(String str) //method level variable  
	{
		this.str = str;
	}
	
	public void printString()
	{
		System.out.println(str);  // 2nd time print
	}
	
	private void MyMethod()
	{
		System.out.println("");
	}

}
