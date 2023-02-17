package conjuntistas.arbol.avl.ArbolAVL.test;

import conjuntistas.ArbolAVL.ArbolAVL;
import conjuntistas.ArbolAVL.Nodo;

public class TestArbolAVLCreacion {

  private Nodo raiz;
  private ArbolAVL arbol;
  private String[] patron;

  public static void RR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    patron = {"RR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void LR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    patron = {"LR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(1);
    print(arbol);
  }

  public static void LRR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    patron = {"LRR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void RLR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    patron = {"RLR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    arbol.eliminar(1);
    print(arbol);
  }

  public static void LRR_RLR() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    patron = {"LRR", "RLR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
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
    patron = {"RLR", "LRR"};
    raiz = CrearArbol.rotacionMultiple(patron);
    arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    print(arbol);
    print(arbol.niveles());
    arbol.eliminar(9);
    print(arbol);
    print(arbol.niveles());
  }

} 
