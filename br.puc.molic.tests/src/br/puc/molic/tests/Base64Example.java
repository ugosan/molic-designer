package br.puc.molic.tests;

import br.puc.molic.util.Base64;

public class Base64Example {

	
	
	public static void main(String[] args) throws Exception{
		
		String result1 = Base64.encodeFromFile("/home/ugo/Desktop/PETROBRAS/SINAPSE/elementos de interface/edicao_area_conhecimento_original.png");
		
		System.out.println(result1);
		System.out.println();
		System.out.println(Base64.encodeFromFile("/home/ugo/Desktop/PETROBRAS/SINAPSE/elementos de interface/inserir_pessoas.png"));
		System.out.println();
		System.out.println(Base64.encodeFromFile("/home/ugo/Desktop/PETROBRAS/SINAPSE/elementos de interface/menu_super1.png"));		
		System.out.println();
		
		
		//Base64.decodeToFile(result1, "/home/ugo/temp/base64.png");
	
		
	}
}
