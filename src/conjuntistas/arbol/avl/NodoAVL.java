package conjuntistas.arbol.avl;

import java.lang.Math;
import conjuntistas.arbol.bb.Nodo;

public class NodoAVL extends Nodo {

  private int altura;

  public NodoAVL(Comparable<?> elemento, Nodo izquierdo, Nodo derecho) {
    super(elemento, izquierdo, derecho);
    this.altura = 0;
    actualizarAltura();
  }

  public NodoAVL(Comparable<?> elemento) {
    this(elemento, null, null);
  }

  public int getAltura() {
    return this.altura;
  }

  public void actualizarAltura() {
    // en caso de no tener hijos se dará la cuenta -1 + 1 = 0
    NodoAVL izquierdo = (NodoAVL) this.izquierdo;
    NodoAVL derecho = (NodoAVL) this.derecho;
    int altura1 = (izquierdo == null) ? -1 : izquierdo.altura;
    int altura2 = (derecho == null) ? -1 : derecho.altura;
    this.altura = Math.max(altura1, altura2) + 1;
  }

  public int getBalance() {
    NodoAVL izquierdo = (NodoAVL) this.izquierdo;
    NodoAVL derecho = (NodoAVL) this.derecho;
    int altura1 = (izquierdo == null) ? -1 : izquierdo.altura;
    int altura2 = (derecho == null) ? -1 : derecho.altura;
    int balance = altura1 - altura2;
    return balance;
  }

  public boolean noEstaBalanceado() {
    return Math.abs(getBalance()) > 1;
  }

}
