class stringCalculator extends GroovyTestCase{

	Calculator obj = new Calculator()

	void testStringIsNull(){
		int res = obj.add(null)
		assert res ==0
	}
	void testStringIsEmpty() {
		int resultado = obj.add("")
		assert resultado == 0
	}
	void testStringHasOneNumber(){
		int res = obj.add("1")
		assert res == 1	
		res = obj.add("7")
		assert res == 7
	}
	void testStringHasTwoNumbers(){
		int res = obj.add("5,3")
		assert res == 8	
		res = obj.add("9,4")
		assert res == 13	
	}
	void testStringHasThreeNumbers(){
		int res = obj.add("5,3,4")
		assert res == 12	
		res = obj.add("9,4,7")
		assert res == 20	
	}
	void testStringHasAnyQuantityNumbers(){
		int res = obj.add("5,3,3,2,1")
		assert res == 14	
		res = obj.add("2,4")
		assert res == 6
		res = obj.add("3,7,0,4")
		assert res == 14
	}
	void testStringHasNewLineBetweenTheNumbers(){
		int res = obj.add("1\n2,3")
		assert res == 6	
		res = obj.add("12\n3")
		assert res == 15
	}
	void testStringHasTwoSlashAtTheBeginningAndDifferentDelimiter(){
		int res = obj.add("//;\n1;2")
		assert res == 3
		 res = obj.add("//#\n12#3")
		assert res == 15
	}
	void testStringHasNegativesNumbers(){
		def message = shouldFail(Exception){
			obj.add("-1,-2,-3")	
			assert false
		}
		assert message == "Negatives not allowed [-1, -2, -3]"
	}
	void testStringHasOneNegativeNumber(){
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
			returnZero(numbers)
		}else {
			checkNumbersInTheString(numbers)
		}
	}
	def returnZero(numbers){
		0
	}
	def checkNumbersInTheString(numbers){
		def newNumbers = replaceFullNotationAtTheBegenningOfTheString(numbers)
		if(newNumbers.contains('-')){
			throw new Exception("Negatives not allowed ${splittngNegativeNumbersInTheString(newNumbers)}")
		}
		spllitingDelimiterBetweenNumbersAndSum(newNumbers)
	}
	def replaceFullNotationAtTheBegenningOfTheString(numbers){
		numbers.replaceAll('//[\\D][\\s]|', '')
	}

	def spllitingDelimiterBetweenNumbersAndSum(newNumbers){
		newNumbers.split('\\D').collect {it.toInteger()}.sum()
	}
	def splittngNegativeNumbersInTheString(newNumbers){
		newNumbers.split(',').collect{it.toInteger()}.findAll{it < 0}
	}

}
