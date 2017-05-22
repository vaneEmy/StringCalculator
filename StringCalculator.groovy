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
	void testStringHasTwoSlashAtTheBeginningAndDifferentDelimiter(){
		Calculator obj = new Calculator()
		int res = obj.add("//;\n1;2")
		assert res == 3
		 res = obj.add("//#\n12#3")
		assert res == 15
	}
	void testStringHasNegativesNumbers(){
		Calculator obj = new Calculator()
		def message = shouldFail(Exception){
			obj.add("-1,-2,-3")	
			assert false
		}
		assert message == "Negatives not allowed [-1, -2, -3]"
	}
	void testStringHasOneNegativeNumber(){
		Calculator obj = new Calculator()
		def message = shouldFail(Exception){
			obj.add("-1, 2")
			assert false

		}
		assert message == "Negatives not allowed [-1]"	
	}
	 
}

class Calculator{
	int add (String numbers){
		if(!numbers){
			0
		}else {
			int sum = 0
			def negativeNumbers = []
			def newNumbers = numbers.replaceAll('//[\\D][\\s]|', '')
			if(newNumbers.contains('-')){
				negativeNumbers = newNumbers.split(',').collect{it.toInteger()}.findAll{it < 0}
				throw new Exception("Negatives not allowed ${negativeNumbers}")
			}
			newNumbers.split('\\D').collect {it.toInteger()}.sum()
			
			
			
		}

	}
}
