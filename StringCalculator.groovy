class stringCalculator extends GroovyTestCase{

	void testNull(){
		Calculator obj = new Calculator()
		int res = obj.add(null)
		assert res ==0
	}
	void testEmpty() {
		Calculator obj = new  Calculator()
		int resultado = obj.add("")
		assert resultado == 0
	}
	void testOneNumber(){
		Calculator obj = new  Calculator()
		int res = obj.add("1")
		assert res == 1	
		res = obj.add("7")
		assert res == 7
	}
	void testTwoNumbers(){
		Calculator obj = new  Calculator()
		int res = obj.add("5,3")
		assert res == 8	
		res = obj.add("9,4")
		assert res == 13	
	}
}

class Calculator{
	int add (String numbers){
		if(!numbers){
			0
		}else{
			def values = []
			values = numbers.split(",")
			int sum = 0  	
			for(element in values) {
				sum += element.toInteger()
			}
			sum
		}
	}
}
