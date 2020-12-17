package com.sastry.server.main.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class SupplierDaoService 
{
public static int usersCount=5;
//creating an instance of ArrayList
private static List<Supplier> users=new ArrayList<>();
//static block 
static
{
//adding users to the list
users.add(new Supplier(1, "John"));
users.add(new Supplier(2, "Robert"));
users.add(new Supplier(3, "Ben"));
users.add(new Supplier(4, "Bindu"));
users.add(new Supplier(5, "Jack"));
}
//method that retrieve all users from the list
public List<Supplier> findAll()
{
return users;
}
//method that adds a user in the list 
public Supplier save(Supplier user)
{
if(user.getId()==null)
{
user.setId(++usersCount);
}
users.add(user);
return user;
}
//method that find a particular user from the list
public Supplier findOne(int id)
{
for(Supplier user:users)
{
if(user.getId()==id)
return user;
}
return null;
}
//method that delete a user resource
public Supplier deleteById(int id)
{
Iterator<Supplier> iterator = users.iterator();
while(iterator.hasNext())
{
Supplier user=iterator.next();
if(user.getId()==id)
{
iterator.remove();
return user; //returns the deleted resource back
}
}
return null;
}
}
