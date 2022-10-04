package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;
import java.lang.reflect.Method;

public class RotacionSimple {

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

  public static void callAll() throws Exception {
    Method[] methods = RotacionSimple.class.getDeclaredMethods();
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    String name;
    for (Method method : methods) {
      name = method.getName();
      if (!name.equals(methodName)) {
        System.out.println("TEST - " + name);
        method.invoke(null);
      }
    }
  }

}
