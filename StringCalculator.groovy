class stringCalculator extends GroovyTestCase{

	void testStringIsNull(){
		Calculator obj = new Calculator()
		int res = obj.add(null)
		assert res ==0
	}
	void testStringIsEmpty() {
		Calculator obj = new  Calculator()
		int resultado = obj.add("")
		assert resultado == 0
	}
	void testStringHasOneNumber(){
		Calculator obj = new  Calculator()
		int res = obj.add("1")
		assert res == 1	
		res = obj.add("7")
		assert res == 7
	}
	void testStringHasTwoNumbers(){
		Calculator obj = new  Calculator()
		int res = obj.add("5,3")
		assert res == 8	
		res = obj.add("9,4")
		assert res == 13	
	}
	void testStringHasThreeNumbers(){
		Calculator obj = new  Calculator()
		int res = obj.add("5,3,4")
		assert res == 12	
		res = obj.add("9,4,7")
		assert res == 20	
	}
	void testStringHasAnyQuantityNumbers(){
		Calculator obj = new  Calculator()
		int res = obj.add("5,3,3,2,1")
		assert res == 14	
		res = obj.add("2,4")
		assert res == 6
		res = obj.add("3,7,0,4")
		assert res == 14
	}
	void testStringHasNewLineBetweenTheNumbers(){
		Calculator obj = new  Calculator()
		int res = obj.add("1\n2,3")
		assert res == 6	
		res = obj.add("12\n3")
		assert res == 15
	}
	void testStringWithTwoSlashAtTheBeginningAndDifferentDelimiter(){
		Calculator obj = new Calculator()
		int res = obj.add("//;\n1;2")
		assert res == 3
		 res = obj.add("//#\n12#3")
		assert res == 15
	}
	 
}

class Calculator{
	int add (String numbers){
		if(!numbers){
			0
		}else{
			if(numbers.startsWith("//")){
				def newNumbers = numbers.replaceAll('//[\\D][\\s]', '')
				def values = []
				values =newNumbers.split('\\D')
				int sum = 0
				values.each{
					sum += it.toInteger()
				}
				sum
			}else{
				def values = []
				values = numbers.split('\n|,')
				int sum = 0
				values.each{
					sum += it.toInteger()
				}  	
				sum
			}
			
		}
	}
}
