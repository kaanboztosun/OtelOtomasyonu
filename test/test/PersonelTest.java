/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Personel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rozerin
 */
public class PersonelTest {
    

     @Test
     public void test() {
         Personel p1 = new Personel("Rozerin","Teomete","asd","45645");
         String result ="45645";
         assertEquals(p1.getMaas(), result);
     }
}

