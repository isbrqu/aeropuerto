package conjuntistas.ArbolAVL;

import lineales.dinamicas.Lista;

public class ArbolAVL {

  private Nodo raiz;

  public ArbolAVL() {
    this.raiz = null;
  }

  public boolean esVacio() {
    return this.raiz == null;
  }

  public boolean insertar(Comparable elemento) throws Exception {
    Nodo hijo = insertarAux(this.raiz, elemento);
    // hijo == null se pudo insertar y no hubo ratacion
    // elemento != null se pudo insertar y hubo ratacion
    // elemento == null no se pudo insertar y no hubo rotacion
    boolean exito = (hijo == null || hijo.getElemento() != null);
    return exito;
  }

  public Nodo insertarAux(Nodo nodo, Comparable elemento) throws Exception {
    Nodo hijo = new Nodo(null);
    if (this.raiz == null) {
      this.raiz = new Nodo(elemento);
      hijo = null;
    } else if (!elemento.equals(nodo.getElemento())) {
      hijo = insertarNodo(nodo, elemento);
      if (hijo == null || hijo.getElemento() != null) {
        nodo.recalcularAltura();
        // en caso de balancear se reasignara el hijo en insertarNodo
        if (nodo.noEstaBalanceado()) {
          hijo = balancear(nodo);
          if (nodo == this.raiz)
            this.raiz = hijo;
        }
      }
    }
    return hijo;
  }

  public Nodo insertarNodo(Nodo nodo, Comparable elemento) throws Exception {
    Nodo hijo = null;
    Comparable contenido = nodo.getElemento();
    Nodo izquierdo = nodo.getIzquierdo();
    Nodo derecho = nodo.getDerecho();
    // determina si elemento es menor o mayor que contenido
    if (elemento.compareTo(contenido) < 0) {
      // Si tiene HI baja a la izquierda, sino agrega elemento
      if (izquierdo == null)
        nodo.setIzquierdo(new Nodo(elemento));
      else
        hijo = insertarAux(izquierdo, elemento);
      // verifica para actualizar el hijo
      if (hijo != null) {
        if (hijo.getElemento() != null)
          nodo.setIzquierdo(hijo);
        else
          nodo = hijo;
      }
    } else {
      // Si tiene HD baja a la derecha, sino agrega elemento
      if (derecho == null)
        nodo.setDerecho(new Nodo(elemento));
      else
        hijo = insertarAux(derecho, elemento);
      // verifica para actualizar el hijo
      if (hijo != null) {
        if (hijo.getElemento() != null)
          nodo.setDerecho(hijo);
        else
          nodo = hijo;
      }
    }
    return nodo;
  }

  public boolean eliminar(Comparable x) throws Exception {
    return eliminarAux(this.raiz, null, x);
  }

  // baja hasta encontrar el nodo
  private boolean eliminarAux(Nodo nodo, Nodo padre, Comparable x) throws Exception {
    boolean exito = false;
    if (nodo != null) {
      Comparable elemento = nodo.getElemento();
      if (elemento.equals(x)) {
        // elimina el nodo
        exito = eliminarNodo(nodo, padre);
      } else if (elemento.compareTo(x) > 0) {
        // desciende por la izquierda del arbol (es menor)
        exito = eliminarAux(nodo.getIzquierdo(), nodo, x);
      } else {
        // desciende por la derecha del arbol (es mayor)
        exito = eliminarAux(nodo.getDerecho(), nodo, x);
      }
    }
    // apendice balanceador
    if (exito) {
      // cuando no sea la raiz
      if (padre != null)
        padre.recalcularAltura();
      // solo para el elemento que se borro
      // nodo no es null por más que se borre
      if (nodo != null) {
        balancear(nodo);
        nodo.recalcularAltura();
      }
    }
    return exito;
  }

  // determina el tipo de eliminacion
  private boolean eliminarNodo(Nodo nodo, Nodo padre) {
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
      // elimino un nodo con un hijo, uno izquierdo o derecho, pero no ambos
      eliminarConUnHijo(nodo, padre);
    }
    return true;
  }

  // caso 1
  private void eliminarHoja(Nodo hijo, Nodo padre) {
    if (padre == null) {
      // caso especial un unico elemento
      this.raiz = null;
    } else if (padre.getIzquierdo() == hijo) {
      padre.setIzquierdo(null);
    } else {
      padre.setDerecho(null);
    }
  }

  // caso 2
  private void eliminarConUnHijo(Nodo hijo, Nodo padre) {
    Nodo izquierdo = hijo.getIzquierdo();
    Nodo derecho = hijo.getDerecho();
    if (padre == null) {
      // caso especial de la raiz con un hijo
      this.raiz = (izquierdo != null) ? izquierdo : derecho;
    } else if (izquierdo != null) {
      padre.setIzquierdo(izquierdo);
    } else {
      padre.setDerecho(derecho);
    }
  }

  // caso 3
  private void eliminarConDosHijos(Nodo nodo) {
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

  private Nodo balancear(Nodo nodo) throws Exception {
    Nodo izquierdo = nodo.getIzquierdo();
    Nodo derecho = nodo.getDerecho();
    int balance = nodo.getBalance();
    int balanceIzq = izquierdo == null ? 0 : izquierdo.getBalance();
    int balanceDer = derecho == null ? 0 : derecho.getBalance();
    if (balance > 0 && balanceIzq >= 0)
      nodo = rotarDerecha(nodo);
    else if (balance < 0 && balanceDer <= 0)
      nodo = rotarIzquierda(nodo);
    else if (balance > 0 && balanceIzq < 0)
      nodo = rotarIzquierdaDerecha(nodo);
    else if (balance < 0 && balanceDer > 0)
      nodo = rotarDerechaIzquierda(nodo);
    else
      throw new Exception("balance esta dando cualquier cosa");
    // nodo debe siempre contener la referencia a un hijo balanceado
    return nodo;
  }

  private Nodo rotarIzquierda(Nodo nodo) {
    // pivot
    Nodo derecho = nodo.getDerecho();
    // temporal
    Nodo izquierdo = derecho.getIzquierdo();
    derecho.setIzquierdo(nodo);
    nodo.setDerecho(izquierdo);
    // recalculo altura de nodo y su "hijo"
    nodo.recalcularAltura();
    derecho.recalcularAltura();
    return derecho;
  }

  private Nodo rotarDerecha(Nodo nodo) {
    // pivot
    Nodo izquierdo = nodo.getIzquierdo();
    // temporal
    Nodo derecho = izquierdo.getDerecho();
    izquierdo.setDerecho(nodo);
    nodo.setIzquierdo(derecho);
    // recalculo altura del nodo y su "hijo"
    nodo.recalcularAltura();
    izquierdo.recalcularAltura();
    return izquierdo;
  }

  private Nodo rotarIzquierdaDerecha(Nodo nodo) {
    Nodo izquierdo = rotarIzquierda(nodo.getIzquierdo());
    nodo.setIzquierdo(izquierdo);
    nodo = rotarDerecha(nodo);
    return nodo;
  }

  private Nodo rotarDerechaIzquierda(Nodo nodo) {
    Nodo derecho = rotarDerecha(nodo.getDerecho());
    nodo.setDerecho(derecho);
    nodo = rotarIzquierda(nodo);
    return nodo;
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

  // utilidad, no prestar antencion
  public void llenar(int[] num) throws Exception {
    for (int n: num)
      this.insertar(n);
  }

  // copiado de arbol binario
  public String toString() {
    return (this.raiz != null) ? toStringAux(this.raiz, "") : "Arbol Vacio";
  }

  // copiado de arbol binario
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

}
