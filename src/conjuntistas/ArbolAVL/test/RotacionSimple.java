package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class RotacionSimple {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void derechaEnRaiz() throws Exception {
    print("TEST SET 1 - Rotacion derecha en raiz");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 1};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void derechaHijoIzquierdo() throws Exception {
    print("TEST SET 2 - Rotacion derecha en hijo izquierdo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 4, 6, 3, 2};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void derechaHijoDerecho() throws Exception {
    print("TEST SET 3 - Rotacion derecha en hijo derecho");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 6, 5, 4};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void izquierdaEnRaiz() throws Exception {
    print("TEST SET 1 - Rotacion izquierda en raiz");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {1, 3, 5};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void izquierdaHijoIzquierdo() throws Exception {
    print("TEST SET 2 - Rotacion izquierda en hijo izquierdo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 4, 5, 6};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void izquierdaHijoDerecho() throws Exception {
    print("TEST SET 3 - Rotacion izquierda en hijo derecho");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 2, 6, 3, 4};
    arbol.llenar(serie);
    print(arbol);
  }
}
