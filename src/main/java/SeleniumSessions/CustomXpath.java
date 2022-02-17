package SeleniumSessions;

public class CustomXpath {

	public static void main(String[] args) {
		// xpath:address of the element in HTML DOM
		// absolute xpath:html/body/div[2]/div[1]/ul[]3/ul[2]/a - v dont prefer this -
		// the div or any tag can be changed
		// relative path:custome path:functions,prop,xpath axes

		// htmltag[@attr='value']
		// input[@id='input-email']
		// multiple attributes
		// input[@id='input-email' and @name] - this is also correct
		// input[@id='input-email' and @name='email']
		// input[@id='input-email' or @name='email'] - or will give u either of them
		// input[@type='submit' or @value='Login']

		// *[@attr='value']
		// *[@id='input-email'] - * keeps searching all the elements like 300 elements
		// input[@id='input-email']- this searches nly 10 elements

		// input[@class='form-control'] - this gives 2 results
		// for index based capture braces () is compulsory
		// (//input[@class='form-control'])[1] -index based xpath - 1 will give u the email element, 2 gives pwd
		// (//input[@class='form-control'])[position()=4] - this is also index based
		// (//input[@class='form-control'])[last()]

		// Interview question-find the last element of last row/last column
		// ((//div[@class='navFooterVerticalColumn navAccessibility']//ul)[4]//a)[last()]
		// ((//div[@class='navFooterVerticalColumn navAccessibility']//ul)[last()]//a)[last()] - 4 is replaced by last-no hardcode

		// text()
		// htmltag[text()='value']
		// a[text()='Blog']
		// label[text()='First Name'
		// h1[text()='Register Account']

		// @attr and text():
		// htmltag[@attr='value' and text()='value']
		// a[@href and text()='login page']
		// label[@for='input-firstname' and text()='First Name']
		//label[ text()='First Name' and @for='input-firstname']- reverse the order
		
	//	contains() with attr:
		//htmltag[contains(@attr), 'value'
		//input[contains(@id,'input-firstname')]
		
		//input-firstname this can be changed in future
		//123-firstname - like this
		//input[contains(@id,'-firstname')] - so this way the partial id with - can be given for dynamic values
		//input[contains(@id,'-firstname') and contains(@name,'firstname')] - with 2 attr
		
		//	contains() with attr1 and attr2 with no contains:(can be anywhere)
		//input[contains(@id,'-firstname') and @name='firstname'] - or the order can be reversed contains() with text():
		//p[contains(text(),'SaaS solutions')]
		//a[contains(text(),'Fresh')]
		
		//starts-with()
		//a[starts-with(text(),'Fresh')] - 5 results
		//*[starts-with(text(),'Fresh')] - this gives everthng with fresh - 19 results
		
		//parent to child:
		//form[@id='Form_submitForm']//input-- 15 results(direct +indirect child elements
		//form[@id='Form_submitForm']/input- 0 results(direct)
		
		//div[@class='private-form__input-wrapper']//input - this gives u direct and indirect
		//div[@class='private-form__input-wrapper']//input[@id='username']
		//div[@class='private-form__input-wrapper']/child::input[@id='username'] - another way for getting child
					
		//select[@id='Form_submitForm_Country']/option
		//select[@id='Form_submitForm_Country']/child::option - another way
		//select[@id='Form_submitForm_Country']/* - all the child elements
		
		//child to parent:
		//iner question- how will u reach from child to parent- =>this approach is backward direction
		//option[@value='Afghanistan']/../../../../../../../../../../..
		//option[@value='Afghanistan']/parent::select/parent::div => another way
		//input[@id='Form_submitForm_Name']/ancestor::form - this is for not immediate parent=>gets to the top tag
		//input[@id='Form_submitForm_Name']/ancestor::form[@id='Form_submitForm']- another way( more accurate way)
		//(//input[@id='Form_submitForm_Name']/ancestor::div)[last()]=> among 6 divs=>take u to last div
		
		
		
		
		
	}

}
