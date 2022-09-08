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

  public static void derechaHijoIzquierdo() throws Exception {
    print("TEST SET 2 - Rotacion derecha en hijo izquierdo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 6, 5, 4};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void rotarIzquierda2() throws Exception {
    print("TEST SET 2 - Rotacion izquierda");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 5, 1, 8};
    arbol.llenar(serie);
    print(arbol);
  }

}
