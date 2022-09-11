package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class RotacionDoble {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void izquierdaDerechaEnRaiz() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en raiz");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 4};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void izquierdaDerechaEnHijoIzquierdo() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en hijo izquierdo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 3, 5, 1, 2};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void izquierdaDerechaEnHijoDerecho() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en hijo derecho");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {2, 1, 5, 3, 4};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void derechaIzquierdaEnRaiz() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en raiz");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {1, 3, 2};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void derechaIzquierdaEnHijoIzquierdo() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en hijo izquierdo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 1, 5, 3, 2};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void derechaIzquierdaEnHijoDerecho() throws Exception {
    print("TEST SET 1 - Rotacion doble izquierda-derecha en hijo derecho");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {2, 1, 3, 5, 4};
    arbol.llenar(serie);
    print(arbol);
  }

}
