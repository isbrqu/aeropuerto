package conjuntistas.arbol.bb;

import conjuntistas.arbol.bb.Nodo;
import lineales.dinamicas.Lista;

public class ArbolBB extends ArbolBinarioBusquedaBase {

  public ArbolBB() {
    super();
  }

  public boolean insertar(Comparable elemento) {
    boolean exito = true;
    if (this.raiz == null) {
      this.raiz = new Nodo(elemento);
    } else {
      exito = this.insertar(this.raiz, elemento);
    }
    return exito;
  }

  private boolean insertar(Nodo nodo, Comparable elemento) {
    // precondicion: nodo no es nulo
    boolean exito = true;
    if (elemento.equals(nodo.getElemento())) {
      // reportar error: elemento repetido
      exito = false;
    } else if (elemento.compareTo(nodo.getElemento()) < 0) {
      // elemento es menor que nodo.getElemento()
      // si tiene HI baja a la izquierda, sino agrega elemento
      if (nodo.getIzquierdo() != null) {
        exito = this.insertar(nodo.getIzquierdo(), elemento);
      } else {
        nodo.setIzquierdo(new Nodo(elemento));
      }
    } else if (nodo.getDerecho() != null) {
      // elemento es mayor que nodo.getElemento()
      // si tiene HD baja a la derecha, sino agrega elemento
      exito = this.insertar(nodo.getDerecho(), elemento);
    } else {
      nodo.setDerecho(new Nodo(elemento));
    }
    return exito;
  }

  public boolean eliminar(Comparable x) {
    return this.eliminar(this.raiz, null, x);
  }

  private boolean eliminar(Nodo nodo, Nodo padre, Comparable x) {
    boolean exito = false;
    if (nodo != null) {
      Comparable elemento = nodo.getElemento();
      if (elemento.equals(x)) {
        // elimina el nodo
        exito = eliminarNodo(nodo, padre);
      } else if (elemento.compareTo(x) > 0) {
        // desciende por la izquierda del arbol (es menor)
        exito = this.eliminar(nodo.getIzquierdo(), nodo, x);
      } else {
        // desciende por la derecha del arbol (es mayor)
        exito = this.eliminar(nodo.getDerecho(), nodo, x);
      }
    }
    return exito;
  }

}
