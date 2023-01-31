package conjuntistas.arbol.manipulador;

import conjuntistas.arbol.bb.Nodo;
import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.avl.NodoAVL;

public class Comprobador {

  private ArbolBBBase arbol;
  private Nodo raiz;

  public Comprobador(ArbolBBBase arbol) {
    this.arbol = arbol;
    this.raiz = arbol.getRaiz();
  }

  public boolean pertenece(Comparable x) {
    boolean pertenece = false;
    Nodo nodo = this.raiz;
    Comparable elemento;
    while (nodo != null && !pertenece) {
      elemento = nodo.getElemento();
      if (elemento.equals(x)) {
        pertenece = true;
      } else if (elemento.compareTo(x) > 0) {
        nodo = nodo.getIzquierdo();
      } else if (elemento.compareTo(x) < 0) {
        nodo = nodo.getDerecho();
      }
    }
    return pertenece;
  }

  public boolean esVacio() {
    return this.raiz == null;
  }


} 
