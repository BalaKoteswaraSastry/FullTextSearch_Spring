package com.sastry.server.main.filtering;
import com.fasterxml.jackson.annotation.JsonFilter;
@JsonFilter("SomeBeanFilter")
public class SomeBean 
{
private  String name;

//JsonIgnore indicates that the annotated method or field is to be ignored
//@JsonIgnore
private  String salary;
//generating constructor
public SomeBean(String name, String quantity) 
{
super();	
this.name = name;
this.salary = salary;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}

public String getQuantity() 
{
return quantity;
}
public void setQuantity(String quantity) 
{
this.quantity= quantity;
}
}
