package com.aconsolaro.calculadora.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aconsolaro.calculadora.rest.exception.UnsuportedMathOperationException;
import com.aconsolaro.calculadora.rest.utils.NumericUtils;

@RestController
public class CalculadoraController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = NumericUtils.convertToDouble(numberOne) + NumericUtils.convertToDouble(numberTwo);
		return sum;
	}

	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = NumericUtils.convertToDouble(numberOne) - NumericUtils.convertToDouble(numberTwo);
		return sum;
	}

	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = NumericUtils.convertToDouble(numberOne) * NumericUtils.convertToDouble(numberTwo);
		return sum;
	}

	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = NumericUtils.convertToDouble(numberOne) / NumericUtils.convertToDouble(numberTwo);
		return sum;
	}

	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = (NumericUtils.convertToDouble(numberOne) + NumericUtils.convertToDouble(numberTwo))/2;
		return sum;
	}

	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if (!NumericUtils.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return Math.sqrt(NumericUtils.convertToDouble(number));
	}
}