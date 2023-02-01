package conjuntistas.arbol.manipulador;

import conjuntistas.arbol.bb.Nodo;
import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.avl.NodoAVL;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Listador {

  private ArbolBBBase arbol;
  private Nodo raiz;

  public Listador(ArbolBBBase arbol) {
    this.arbol = arbol;
    this.raiz = arbol.getRaiz();
  }

  public boolean esVacio() {
    return this.raiz == null;
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

  public Lista listarRango(int minimo, int maximo) {
    Lista lista = new Lista();
    listarRangoAux(this.raiz, lista, minimo, maximo);
    return lista;
  }

  private void listarRangoAux(Nodo nodo, Lista lista, int minimo, int maximo) {
    if (nodo != null) {
      Comparable elemento = nodo.getElemento();
      if (elemento.compareTo(maximo) < 0)
        listarRangoAux(nodo.getDerecho(), lista, minimo, maximo);
      if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0)
        lista.insertar(elemento, 1);
      if (elemento.compareTo(minimo) > 0)
        listarRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
    }
  }

  public Lista niveles() {
    Cola cola = new Cola();
    Pila pila = new Pila();
    Lista lista = new Lista();
    cola.poner(this.raiz);
    Nodo nodo;
    while (cola.obtenerFrente() != null) {
      nodo = (Nodo) cola.obtenerFrente();
      cola.sacar();
      pila.apilar(nodo.getElemento());
      if (nodo.getIzquierdo() != null)
        cola.poner(nodo.getIzquierdo());
      if (nodo.getDerecho() != null)
        cola.poner(nodo.getDerecho());
    }
    while (pila.obtenerTope() != null) {
      lista.insertar(pila.obtenerTope(), 1);
      pila.desapilar();
    }
    return lista;
  }

}
