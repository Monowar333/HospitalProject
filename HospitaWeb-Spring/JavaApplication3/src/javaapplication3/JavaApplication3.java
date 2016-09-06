/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Жека
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    	


//    public static void main(String[] args) {
//        System.out.println(JavaApplication3.go());
//    }
//
//    public static int go() {
//        try {
//            return 1;
//        } catch (Exception e){
//
//        }finally {
//            return 2;
//        }
//    }
//public static void main(String[] args) {
//				A[] a = new A[]{ new A(), new B()};
//
//				for (A aa: a) {
//					aa.go();
//				}
//			}
    public static void main(String[] args) {
			Help h = new Help();
			h.held = 100;
			h.method(h); //***
			System.out.println(h.held);
		}
}   



