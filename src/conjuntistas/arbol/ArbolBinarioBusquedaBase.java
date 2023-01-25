package conjuntistas.arbol;

import conjuntistas.arbol.Nodo;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public abstract class ArbolBinarioBase {

  protected Nodo raiz;

  public ArbolBinario() {
    this.raiz = null;
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
      s += "HI: " + ((izquierdo != null) ? izquierdo.getElemento() : "-") + "\t";
      s += "HD: " + ((derecho != null) ? derecho.getElemento() : "-");
      s = toStringAux(nodo.getIzquierdo(), s);
      s = toStringAux(nodo.getDerecho(), s);
    }
    return s;
  }

  public void setRaiz(Nodo raiz) {
    this.raiz = raiz;
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

  public void rellenar() {
    rellenarAux(this.raiz, 1);
  }

  public int rellenarAux(Nodo nodo, int i) {
    if (nodo != null) {
      i = rellenarAux(nodo.getIzquierdo(), i);
      nodo.setElemento(i);
      i = rellenarAux(nodo.getDerecho(), i + 1);
      nodo.recalcularAltura();
    }
    return i;
  }

  public void llenar(int[] num) throws Exception {
    for (int n: num)
      this.insertar(n);
  }

  public abstract boolean insertar(Comparable elemento) throws Exception;


}
