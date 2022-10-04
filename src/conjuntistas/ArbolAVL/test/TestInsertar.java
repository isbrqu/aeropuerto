package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;
import java.lang.reflect.Method;

public class TestInsertar {

  // rotacion simple

  public static void derechaEnRaiz() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 1};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void derechaHijoIzquierdo() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 4, 6, 3, 2};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void derechaHijoDerecho() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 6, 5, 4};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void izquierdaEnRaiz() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {1, 3, 5};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void izquierdaHijoIzquierdo() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 4, 5, 6};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void izquierdaHijoDerecho() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 2, 6, 3, 4};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  // rotaciones doble 

  public static void izquierdaDerechaEnRaiz() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 4};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void izquierdaDerechaEnHijoIzquierdo() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 3, 5, 1, 2};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void izquierdaDerechaEnHijoDerecho() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {2, 1, 5, 3, 4};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void derechaIzquierdaEnRaiz() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {1, 3, 2};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void derechaIzquierdaEnHijoIzquierdo() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 1, 5, 3, 2};
    arbol.llenar(serie);
    System.out.println(arbol);
  }

  public static void derechaIzquierdaEnHijoDerecho() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {2, 1, 3, 5, 4};
    arbol.llenar(serie);
    System.out.println(arbol);
  }
  
  // particulares 

  public static void repetidoIterativo() throws Exception {
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 2, 6, 1, 3, 5, 7};
    arbol.llenar(serie);
    for (int num : serie)
      System.out.println("inserta " + num + ": " + arbol.insertar(num));
    System.out.println(arbol);
  }

  public static void callAll() throws Exception {
    Method[] methods = TestInsertar.class.getDeclaredMethods();
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    String name;
    for (Method method : methods) {
      name = method.getName();
      if (!name.equals(methodName)) {
        System.out.println("TEST - " + name);
        method.invoke(null);
        System.out.println();
      }
    }
  }

}
