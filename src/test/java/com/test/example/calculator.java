package com.test.example;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.pages.*;

public class calculator {

Supercalculator calPage;

@BeforeTest
public void setup(){
calPage = new Supercalculator();
}


@Test(priority=1)
public void sum(){
String res = calPage.doSum("21", "2");
Assert.assertEquals(res, "23");
}

@Test(priority=2)
public void subtraction(){
String res = calPage.doSub("21", "2");
Assert.assertEquals(res, "19");
}

@Test(priority=3)
public void multiplication(){
String res = calPage.doMul("21", "2");
Assert.assertEquals(res, "42");
}

@Test(priority=4)
public void division(){
String res = calPage.doDiv("21", "2");
Assert.assertEquals(res, "10.5");
}

@Test(priority=5)
public void Modulo(){
String res = calPage.doModulo("21", "2");
Assert.assertEquals(res, "1");
}
}