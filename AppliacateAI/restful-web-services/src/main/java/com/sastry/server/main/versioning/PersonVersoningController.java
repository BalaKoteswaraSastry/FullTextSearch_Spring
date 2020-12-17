package com.sastry.server.main.versioning;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PersonVersoningController 
{
/*---------------using request parameter--------------*/
//this method is for first version that returns the entire name
@GetMapping(value="/person/param", params="version=1")
public PersonV1 personV1()
{
return new PersonV1("Tom");
}
//this method is for second version that returns firstName and lastName separately
@GetMapping(value="/person/param", params="version=2")
public PersonV2 personV2()
{
return  new PersonV2(new Name("Tom"));
}
/*---------------using request header--------------*/
//this method is for first version that returns the entire name
@GetMapping(value="/person/header", headers="X-API-Version=1")
public PersonV1 headerV1()
{
return new PersonV1("Tom");
}
//this method is for second version that returns firstName and lastName separately
@GetMapping(value="/person/header", headers="X-API-Version=2")
public PersonV2 headerV2()
{
return  new PersonV2(new Name("Tom"));
}
/*---------------using accept header--------------*/
//this method is for first version that returns the entire name
@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
public PersonV1 producesV1()
{
return new PersonV1("Tom");
}
//this method is for second version that returns firstName and lastName separately
@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
public PersonV2 producesV2()
{
return  new PersonV2(new Name("Tom"));
}
}
