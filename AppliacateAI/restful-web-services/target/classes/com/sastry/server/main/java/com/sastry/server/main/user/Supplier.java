package com.sastry.server.main.user;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All details about the supplier")
@Entity
public class Supplier 
{
//Id as a primary key
@Id
@GeneratedValue
private Integer id;//SupplierID
@Size(min=5, message="Name should have atleast 5 characters")
@ApiModelProperty(notes="name should have atleast 5 characters")
private String name;//Supplier Name
//default constructor	
@OneToMany(mappedBy="user")
private List<Product> products; 

protected Supplier()
{
	
}
public Supplier(Integer id, String name) 
{
super();
this.id = id;
this.name = name;
}
public Integer getId() 
{
return id;
}
public void setId(Integer id) 
{
this.id = id;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}
public List<Product> getProducts() 
{
return posts;
}
public void setProducts(List<Product> products) 
{
this.products = products;
}
@Override
public String toString() 
{
//return "Supplier [id=" + id + ", name=" + name + "]";
return String.format("Supplier [id=%s, name=%s]", id, name);
}
}
