/**
KH1886
Rohit Laddha
*/
package com.ami.test;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.wsi.common.CommonValidation;
public class TestValidation {
	CommonValidation val = new CommonValidation();
	
	@Test(enabled=false, description="testing email validation" )
	void validateEmail(){
		String [] correctEmails = {"rohit.laddha@kony.com", "rohit@kony.com","asdf@adf.in"};
		String [] incorrectEmails = {"r@#t.laddha@kony.com",
				"@kony.com","asdf@a#$df.in", "sad@ad.!@"};

		for(String s : correctEmails){
			Assert.assertEquals(val.validateEmail(s).booleanValue(), true);
		}
		for(String s : incorrectEmails){
			Assert.assertEquals(val.validateEmail(s).booleanValue(), false);
		}
	}
	@Test(enabled=false, description = "testing length validation" )
	public void validateNameLength(){
		Assert.assertEquals(val.validateLength("input", 0, 5).booleanValue(), true);
		Assert.assertEquals(val.validateLength("a big string turned down", 4, 6)
				.booleanValue(),false);
	}
	@Test(enabled=false, description="testing name validation")
	public void validateName(){
		String [] correctName = {"roOiThit", "RRRR","qpoweQASDq"};
		String [] incorrectName = {"r@#tom",
				"asdf12asdf","..in", "  "};

		for(String s : correctName){
			Assert.assertEquals(val.validateName(s).booleanValue(), true);
		}
		for(String s : incorrectName){
			Assert.assertEquals(val.validateName(s).booleanValue(), false);
		}
	}
	
	@Test(enabled=true, description="testing password validation")
	public void validatePassword(){
		String [] correctPass = {"rR@1asD", "R@h1Tl@","#@%09FDs"};
		String [] incorrectPass = {"r@#T1",
				"aaaaaaBBBBBBB@#$11aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","RWas123d", "", "rR1^^^^^^"};

		for(String s : correctPass){
			Assert.assertEquals(val.validatePassword(s).booleanValue(), true);
		}
		for(String s : incorrectPass){
			Assert.assertEquals(val.validatePassword(s).booleanValue(), false);
		}
	}
		
}
