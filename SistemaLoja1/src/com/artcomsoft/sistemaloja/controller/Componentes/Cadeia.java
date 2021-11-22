package com.artcomsoft.sistemaloja.controller.Componentes;

public class Cadeia {

          public static String converterStringArray (String cadeia) {
        	      
        	      String resultado = null;    
        	      String [] vetorCadeia = cadeia.split("/"); 
                  resultado ="/"+vetorCadeia[vetorCadeia.length-2]+"/"+vetorCadeia[vetorCadeia.length-1];
                  return resultado;
          }

}
