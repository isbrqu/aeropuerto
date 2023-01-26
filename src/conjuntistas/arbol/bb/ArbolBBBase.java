package conjuntistas.arbol.bb;

import conjuntistas.arbol.bb.Nodo;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

@SuppressWarnings("rawtypes")
public abstract class ArbolBBBase extends ArbolBinarioBase {

  public ArbolBBBase() {
    super();
  }

  public abstract boolean insertar(Comparable elemento)
      throws Exception;

  public abstract boolean eliminar(Comparable elemento)
      throws Exception;

  protected boolean eliminarNodo(Nodo nodo, Nodo padre) {
    Nodo izquierdo = nodo.getIzquierdo();
    Nodo derecho = nodo.getDerecho();
    // determino el caso a eliminar
    if (izquierdo == null && derecho == null) {
      // elimino un nodo hoja (sin hijos)
      eliminarHoja(nodo, padre);
    } else if (izquierdo != null && derecho != null) {
      // elimino un nodo con dos hijos
      eliminarConDosHijos(nodo);
    } else {
      // elimino un nodo con un hijo, uno izquiedo o derecho, pero no ambos
      eliminarConUnHijo(nodo, padre);
    }
    return true;
  }

  // caso 1
  protected void eliminarHoja(Nodo hijo, Nodo padre) {
    if (padre == null) {
      // caso especial un unico elemento
      this.raiz = null;
    } else if (padre.getIzquierdo() == hijo) {
      padre.setIzquierdo(null);
    } else {
      padre.setDerecho(null);
    }
  }

  protected void eliminarConUnHijo(Nodo hijo, Nodo padre) {
    Nodo izquierdo = hijo.getIzquierdo();
    Nodo derecho = hijo.getDerecho();
    Nodo nuevo = (izquierdo != null) ? izquierdo : derecho;
    if (padre == null) {
      // caso especial de la raiz con un hijo
      this.raiz = (izquierdo != null) ? izquierdo : derecho;
    } else if (padre.getIzquierdo() == hijo) {
      padre.setIzquierdo(nuevo);
    } else {
      padre.setDerecho(nuevo);
    }
  }
  // caso 3
  protected void eliminarConDosHijos(Nodo nodo) {
    Nodo candidato = nodo.getDerecho();
    Nodo padreCandidato = nodo;
    // obtengo el menor de los mayores (candidato)
    while (candidato.getIzquierdo() != null) {
      padreCandidato = candidato;
      candidato = candidato.getIzquierdo();
    }
    // remplazo el valor del nodo a eliminar por el valor del candidato
    nodo.setElemento(candidato.getElemento());
    // hijo pude ser null o no
    Nodo hijoCandidato = candidato.getDerecho();
    // elimina el nodo
    // el candidato es el hijo derecho del nodo a eliminar?
    if (nodo.getDerecho() == candidato) {
      // caso especial, el candidato es hijo del nodo
      nodo.setDerecho(hijoCandidato);
    } else {
      // caso comun, el candidato no es hijo del nodo
      padreCandidato.setIzquierdo(hijoCandidato);
    }
  }

}
