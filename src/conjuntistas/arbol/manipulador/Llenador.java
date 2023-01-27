package conjuntistas.arbol.manipulador;

import conjuntistas.arbol.bb.Nodo;
import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.avl.NodoAVL;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class Llenador {

  private ArbolBBBase arbol;
  private Nodo raiz;

  public Llenador(ArbolBBBase arbol) {
    this.arbol = arbol;
    this.raiz = arbol.getRaiz();
  }

  /**
   * method: rellena la estructura del árbol sin tener en cuenta los valor
   * previos o si siquiera tiene.
   */
  public void rellenar() {
    rellenar(this.raiz, 1);
  }

  private int rellenar(Nodo nodo, int i) {
    if (nodo != null) {
      i = rellenar(nodo.getIzquierdo(), i);
      nodo.setElemento(i);
      i = rellenar(nodo.getDerecho(), i + 1);
      if (nodo instanceof NodoAVL)
        ((NodoAVL) nodo).actualizarAltura();
    }
    return i;
  }

  // public void llenar(int[] num) throws Exception {
  //   for (int n: num)
  //     this.insertar(n);
  // }

}
