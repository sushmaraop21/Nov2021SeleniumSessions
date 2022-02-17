package SeleniumSessions;

public class WaitConcept {

	public static void main(String[] args) {
		//wait:
		//1.static wait:Thread.sleep(1000)e1-3secs...(it has to waiat for rest 7 secs also)
		//2.dynamic :Timeout:10..e1..3 secs found...
			//2.a.: WebDriverWait(class)
			//2.b.:Fluentwait(class)
			
			//WebDriverWait(C)-->extends-->Fluentwait(C)--implements-->Wait(I)--Until();
											//until()
											//other methods
		
		//until is defined in wait interface and overridden in fluentwait 
		//interview question
		//y do v need this webdriver class when v have all methods from Fluent class
		//that is because ->selenium doesnt want everyone to create the object of fluent class which has all the methods 
		//defined.instead u can create object of webdriveR which inherits all the methods from its parents
		
		//"WARNING: Do not mix implicit and explicit waits. Doing so can cause unpredictable wait times. 
		//For example setting an implicit wait of 10s and an explicit wait of 15 seconds, could cause a timeout
		//to occur after 20 seconds."
		
		
		
		//never use imp wait in framework
				//case:
				//mix imp wait + exp wait together: never use both waits
				//imp wait : 20 secs
				//e1 --> webdriverwait : 10 secs
				
				//imp wait     |     exp wait
				// 20		   |     10
			//0--> 0           |      0   -> 0 sec
			//x--> 2           |      5   --> 7 secs
			//x--> 0           |      5   --> 5 secs
			//x--> 5	       |      0 ----> 5 secs
			//x-->20	       |     NA  -->   20 secs
			//x --> 0          |     10(max) --> 10 secs
			//x -- 20          |     10(max)  --> 30 secs	
			//x -- 20          |     10(max)  --> 30 secs	--timeout
		
			
		
		
		
		
		
		
		
		
	}

}
