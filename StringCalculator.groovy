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
}

class Calculator{
	int add (String numbers){
		if(!numbers){
			0
		}
	}
}
