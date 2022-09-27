package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;
import conjuntistas.ArbolAVL.Nodo;

public class TestEliminar {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void rotandoDerechaBalanceNeutroEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 2, 5, 1, 3};
    arbol.llenar(serie);
    arbol.eliminar(5);
    print(arbol);
  }

  public static void rotandoDerechaBalancePositivoEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 4, 1};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void rotandoDerechaBalanceNegativoEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 1, 4, 2};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void rotandoDerechaBalancePositivo() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 6, 2, 4, 7, 1};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void rotandoDerechaBalanceNegativo() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {5, 3, 6, 1, 4, 7, 2};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void rotandoDerechaBalanceNeutro() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {6, 4, 8, 2, 5, 7, 9, 1, 3, 10};
    arbol.llenar(serie);
    arbol.eliminar(5);
    print(arbol);
  }

  public static void RR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"RR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void LR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"LR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(1);
    print(arbol);
  }

  public static void LRR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"LRR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void RLR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"RLR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(1);
    print(arbol);
  }

  public static void LRR_RLR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"LRR", "RLR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    print(arbol.niveles());
    arbol.eliminar(4);
    print(arbol);
    print(arbol.niveles());
  }

  public static void RLR_LRR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    String[] patron = {"RLR", "LRR"};
    Nodo raiz = CrearArbol.rotacionMultiple(patron);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    print(arbol.niveles());
    arbol.eliminar(9);
    print(arbol);
    print(arbol.niveles());
  }

}
