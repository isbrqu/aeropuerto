package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;

public class TestArbolAVLEliminar {

  private static String methodName;
  private static ArbolAVL arbol;
  private static int[] serie;

  public static void derechaBalanceNeutroEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{4, 2, 5, 1, 3};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(5);
      System.out.println(arbol);
  }

  public static void derechaBalancePositivoEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{3, 2, 4, 1};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(4);
      System.out.println(arbol);
  }

  public static void derechaBalanceNegativoEnRaiz()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{3, 1, 4, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(4);
      System.out.println(arbol);
  }

  public static void derechaBalancePositivo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 3, 6, 2, 4, 7, 1};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(4);
      System.out.println(arbol);
  }

  public static void derechaBalanceNegativo()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{5, 3, 6, 1, 4, 7, 2};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(4);
      System.out.println(arbol);
  }

  public static void derechaBalanceNeutro()
      throws Exception {
      methodName = Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName();
      arbol = new ArbolAVL();
      serie = new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3, 10};
      System.out.println("TEST - " + methodName);
      arbol.llenar(serie);
      arbol.eliminar(5);
      System.out.println(arbol);
  }

}
