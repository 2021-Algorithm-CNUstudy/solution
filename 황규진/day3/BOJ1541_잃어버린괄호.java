package day3;

import java.util.Arrays;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BOJ1541_잃어버린괄호 {

	public static void main(String[] args) throws ScriptException {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.replaceAll("-", ")-(");
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ')') {
				str = str.substring(0,i) + str.substring(i+1, str.length());
				break;
			}
		}
		str = str + ")";
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByMimeType("JavaScript");
		Object result = null;
		result = engine.eval(str);
		System.out.println(result);
//		System.out.println(engine.eval(str));

	}

}
