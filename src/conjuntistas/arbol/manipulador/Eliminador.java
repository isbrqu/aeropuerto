package conjuntistas.arbol.manipulador;

import conjuntistas.arbol.bb.Nodo;
import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.avl.NodoAVL;

public class Eliminador {

  private ArbolBBBase arbol;
  private Nodo raiz;

  public Eliminador(ArbolBBBase arbol) {
    this.arbol = arbol;
    this.raiz = arbol.getRaiz();
  }

  public boolean eliminarMinimo() {
    boolean exito = false;
    if (this.raiz != null) {
      NodoABB padre = null;
      NodoABB hijo = this.raiz;
      while (hijo.getIzquierdo() != null) {
        padre = hijo;
        hijo = hijo.getIzquierdo();
      }
      if (padre == null) {
        this.raiz = hijo.getDerecho();
      } else {
        padre.setIzquierdo(hijo.getDerecho());
      }
      exito = true;
    }
    return exito;
  }

  public boolean eliminarMaximo() {
    boolean exito = false;
    if (this.raiz != null) {
      NodoABB padre = null;
      NodoABB hijo = this.raiz;
      while (hijo.getDerecho() != null) {
        padre = hijo;
        hijo = hijo.getDerecho();
      }
      if (padre == null) {
        this.raiz = hijo.getIzquierdo();
      } else {
        padre.setDerecho(hijo.getIzquierdo());
      }
      exito = true;
    }
    return exito;
  }

}
