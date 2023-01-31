package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import java.lang.reflect.Method;

public class TestArbolAVLInsertar {

  private static String methodName;
  private static ArbolAVL arbol;
  private static int[] serie;

  // rotacion simple

  public static void derechaEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 3, 1};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void derechaHijoIzquierdo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 4, 6, 3, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void derechaHijoDerecho()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{3, 2, 6, 5, 4};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void izquierdaEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{1, 3, 5};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void izquierdaHijoIzquierdo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{3, 2, 4, 5, 6};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void izquierdaHijoDerecho()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 2, 6, 3, 4};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  // rotaciones doble 

  public static void izquierdaDerechaEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 3, 4};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void izquierdaDerechaEnHijoIzquierdo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{4, 3, 5, 1, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void izquierdaDerechaEnHijoDerecho()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{2, 1, 5, 3, 4};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void derechaIzquierdaEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{1, 3, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void derechaIzquierdaEnHijoIzquierdo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{4, 1, 5, 3, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  public static void derechaIzquierdaEnHijoDerecho()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{2, 1, 3, 5, 4};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      System.out.println(arbol);
  }

  // particulares 

  public static void repetidoIterativo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{4, 2, 6, 1, 3, 5, 7};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      for (int num : serie)
        System.out.println("inserta " + num + ": " + arbol.insertar(num));
      System.out.println(arbol);
  }

}
