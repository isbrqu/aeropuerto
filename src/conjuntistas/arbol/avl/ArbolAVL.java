package conjuntistas.arbol.avl;

import conjuntistas.arbol.bb.ArbolBBBase;
import conjuntistas.arbol.bb.Nodo;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ArbolAVL extends ArbolBBBase {

  public ArbolAVL() {
    super();
  }

  public boolean insertar(Comparable elemento)
  throws Exception {
    Nodo hijo = insertar(this.raiz, elemento);
    // hijo == null se pudo insertar y no hubo ratacion
    // elemento != null se pudo insertar y hubo ratacion
    // elemento == null no se pudo insertar y no hubo rotacion
    boolean exito = (hijo == null || hijo.getElemento() != null);
    return exito;
  }

  public Nodo insertar(Nodo nodo, Comparable elemento)
  throws Exception {
    Nodo hijo = new NodoAVL(null);
    if (this.raiz == null) {
      this.raiz = new NodoAVL(elemento);
      hijo = null;
    } else if (!elemento.equals(nodo.getElemento())) {
      hijo = insertarNodo(nodo, elemento);
      if (hijo == null || hijo.getElemento() != null) {
        NodoAVL actual = (NodoAVL) nodo;
        actual.actualizarAltura();
        // en caso de balancear se reasignara el hijo en insertarNodo
        if (actual.noEstaBalanceado()) {
          hijo = balancear(actual);
          if (actual == this.raiz)
            this.raiz = hijo;
        }
      }
    }
    return hijo;
  }

  public Nodo insertarNodo(Nodo nodo, Comparable elemento)
  throws Exception {
    Nodo hijo = null;
    Comparable contenido = nodo.getElemento();
    Nodo izquierdo = nodo.getIzquierdo();
    Nodo derecho = nodo.getDerecho();
    // determina si elemento es menor o mayor que contenido
    if (elemento.compareTo(contenido) < 0) {
      // Si tiene HI baja a la izquierda, sino agrega elemento
      if (izquierdo == null)
        nodo.setIzquierdo(new NodoAVL(elemento));
      else
        hijo = insertar(izquierdo, elemento);
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
        nodo.setDerecho(new NodoAVL(elemento));
      else
        hijo = insertar(derecho, elemento);
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

  public boolean eliminar(Comparable x)
  throws Exception {
    return eliminar(this.raiz, null, x);
  }

  private boolean eliminar(Nodo nodo, Nodo padre, Comparable x)
  throws Exception {
    // baja hasta encontrar el nodo
    boolean exito = false;
    if (nodo != null) {
      Comparable elemento = nodo.getElemento();
      if (elemento.equals(x)) {
        // elimina el nodo
        exito = eliminarNodo(nodo, padre);
      } else if (elemento.compareTo(x) > 0) {
        // desciende por la izquierda del arbol (es menor)
        exito = eliminar(nodo.getIzquierdo(), nodo, x);
      } else {
        // desciende por la derecha del arbol (es mayor)
        exito = eliminar(nodo.getDerecho(), nodo, x);
      }
    }
    // si nodo fue borrado hay que asegurarse que
    // nodo no es nulo para los demas casos a balancear
    if (exito && nodo != null) {
      NodoAVL actual = (NodoAVL) nodo;
      actual.actualizarAltura();
      if (actual.noEstaBalanceado()) {
        Nodo hijo = balancear(actual);
        if (actual == this.raiz) {
          this.raiz = hijo;
        } else {
          if (padre.getIzquierdo() == actual)
            padre.setIzquierdo(hijo);
          else
            padre.setDerecho(hijo);
        }
      }
    }
    return exito;
  }

  private Nodo balancear(NodoAVL nodo)
  throws Exception {
    // aquí se va a necesitar castear a NodoAVL al igual que en los
    // rotar
    NodoAVL izquierdo = (NodoAVL) nodo.getIzquierdo();
    NodoAVL derecho = (NodoAVL) nodo.getDerecho();
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

}
