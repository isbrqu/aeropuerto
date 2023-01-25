package conjuntistas.ArbolAVL;
import java.lang.Math;

public class Nodo {

  private int altura;
  private Comparable elemento;
  private Nodo izquierdo;
  private Nodo derecho;

  public Nodo(Comparable elemento, Nodo izquierdo, Nodo derecho) {
    this.elemento = elemento;
    this.izquierdo = izquierdo;
    this.derecho = derecho;
    this.altura = 0;
    recalcularAltura();
  }

  public Nodo(Comparable elemento) {
    this(elemento, null, null);
  }

  public int getAltura() {
    return this.altura;
  }

  public void recalcularAltura() {
    // en caso de no tener hijos se dará la cuenta -1 + 1 = 0
    int izquierdo = (this.izquierdo == null) ? -1 : this.izquierdo.altura;
    int derecho = (this.derecho == null) ? -1 : this.derecho.altura;
    this.altura = Math.max(izquierdo, derecho) + 1;
  }

  public Comparable getElemento() {
    return this.elemento;
  }

  public void setElemento(Comparable elemento) {
    this.elemento = elemento;
  }

  public Nodo getIzquierdo() {
    return this.izquierdo;
  }

  public void setIzquierdo(Nodo izquierdo) {
    this.izquierdo = izquierdo;
  }

  public Nodo getDerecho() {
    return this.derecho;
  }

  public void setDerecho(Nodo derecho) {
    this.derecho = derecho;
  }

  public int getBalance() {
    int izquierdo = (this.izquierdo == null) ? -1 : this.izquierdo.altura;
    int derecho = (this.derecho == null) ? -1 : this.derecho.altura;
    int balance = izquierdo - derecho;
    return balance;
  }

  public boolean noEstaBalanceado() {
    return Math.abs(getBalance()) > 1;
  }

}
