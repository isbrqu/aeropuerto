package conjuntistas.arbol.manipulador;

import conjuntistas.arbol.bb.Nodo;
import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.avl.NodoAVL;

public class Analizador {

  private ArbolBBBase arbol;
  private Nodo raiz;

  public Analizador(ArbolBBBase arbol) {
    this.arbol = arbol;
    this.raiz = arbol.getRaiz();
  }

  public Comparable minimoElem() {
    Comparable elemento = null;
    Nodo nodo = this.raiz;
    // bajada por la izquierda
    while (nodo != null) {
      elemento = nodo.getElemento();
      nodo = nodo.getIzquierdo();
    }
    return elemento;
  }

  public Comparable maximoElem() {
    Comparable elemento = null;
    Nodo nodo = this.raiz;
    // bajada por la derecha
    while (nodo != null) {
      elemento = nodo.getElemento();
      nodo = nodo.getDerecho();
    }
    return elemento;
  }

} 
