package com.sastry.server.main.filtering;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
@RestController
public class FilteringController 
{
//returning a single bean as response
//values to send name and quantity
@RequestMapping("/filtering")
public MappingJacksonValue retrieveSomeBean()
{
SomeBean someBean=new SomeBean("Bingo","390");
//invoking static method filterOutAllExcept()
SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "quantity");
//creating filter using FilterProvider class
FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
//constructor of MappingJacksonValue class  that has bean as constructor argument
MappingJacksonValue mapping = new MappingJacksonValue(someBean);
//configuring filters
mapping.setFilters(filters);
return mapping;
}
//returning a list of SomeBeans as response
//values to send name and phone
@RequestMapping("/filtering-list")
public MappingJacksonValue retrieveListOfSomeBeans()
{
List<SomeBean> list=Arrays.asList(new SomeBean("Lays","200"), new SomeBean("Bingo", "340"));
//invoking static method filterOutAllExcept()
SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "phone");
FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
//constructor of MappingJacksonValue class that has list as constructor argument
MappingJacksonValue mapping = new MappingJacksonValue(list);
//configuring filter
mapping.setFilters(filters);
return mapping;
}
}
