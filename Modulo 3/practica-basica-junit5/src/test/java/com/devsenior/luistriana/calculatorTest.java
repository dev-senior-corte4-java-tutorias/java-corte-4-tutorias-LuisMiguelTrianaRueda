package com.devsenior.luistriana;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class calculatorTest {

   private  Calculator calculator;
   double resultado;
/* SE USA PARA INICIALIZAR OBJETOS QUE SEAN NECESARIOS PARA LA PRUEBA  */
   @BeforeEach 
   void setUp(){
      // INICIALIZAMOS EL OBJETO PARA QUE SIEMPRE ANTE DE LOS TEST SE USE ESE OBJETO 
      System.out.println(" creando una nueva instancia de calculator ");
      calculator = new Calculator();
      
   }
   @Test 
    void probarSumar(){
        resultado = calculator.add(3, 4);

      assertEquals(7, resultado, " la suma de 5 y 3 deberia ser 8");

    }

    @Test
    void probarResta(){
      resultado = calculator.subtract(67, 66);
      assertEquals(1, resultado, "la resta entre 67 y 66 es 1");
    }

    @Test
    void probardivision(){
     
      /* cuando nuestro metodo lanza una expcecion utilizamos asserThrows  */
    assertThrows(IllegalArgumentException.class, ()-> calculator.divide(10, 0));
    }
  
    @Test
    void probarmultiplicacion(){
      resultado = calculator.multiply(3, 6);

      assertEquals(18, resultado, " el resultado esperado es 18");
    }
}
