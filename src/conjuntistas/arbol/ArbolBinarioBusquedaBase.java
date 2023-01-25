package conjuntistas.arbol;

import conjuntistas.arbol.Nodo;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public abstract class ArbolBinarioBusquedaBase {

  public ArbolBinarioBusquedaBase() {
    super();
  }

  public abstract boolean insertar(Comparable elemento)
      throws Exception;

  public abstract boolean eliminar(Comparable elemento)
      throws Exception;

}
