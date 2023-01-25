package conjuntistas.arbol;

import conjuntistas.arbol.Nodo;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public abstract class ArbolBinarioBase {

  protected Nodo raiz;

  public ArbolBinarioBase() {
    this.raiz = null;
  }

  public Nodo getRaiz() {
    return this.raiz;
  }

  public void setRaiz(Nodo raiz) {
    this.raiz = raiz;
  }

  public boolean esVacio() {
    return this.raiz == null;
  }

  public void vaciar() {
    this.raiz = null;
  }

  public Lista listar() {
    Lista lista = new Lista();
    listarAux(this.raiz, lista);
    return lista;
  }

  public void listarAux(Nodo nodo, Lista lista) {
    if (nodo != null) {
      listarAux(nodo.getDerecho(), lista);
      lista.insertar(nodo.getElemento(), 1);
      listarAux(nodo.getIzquierdo(), lista);
    }
  }

  public String toString() {
    // substring(1) elimina el primer salto de linea
    return (this.raiz != null) ?
      toStringAux(this.raiz, "").substring(1) : "Arbol Vacio";
  }

  private String toStringAux(Nodo nodo, String s) {
    if (nodo != null) {
      s += "\n" + nodo.getElemento() + "\t";
      Nodo izquierdo = nodo.getIzquierdo();
      Nodo derecho = nodo.getDerecho();
      s += "HI: " + ((izquierdo != null)
          ? izquierdo.getElemento() : "-") + "\t";
      s += "HD: " + ((derecho != null)
          ? derecho.getElemento() : "-");
      s = toStringAux(nodo.getIzquierdo(), s);
      s = toStringAux(nodo.getDerecho(), s);
    }
    return s;
  }

}
