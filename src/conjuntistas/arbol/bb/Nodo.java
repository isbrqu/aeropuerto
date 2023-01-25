package conjuntistas.arbol;

public class Nodo {

  private Comparable<?> elemento;
  protected Nodo izquierdo;
  protected Nodo derecho;

  public Nodo(Comparable<?> elemento, Nodo izquierdo, Nodo derecho) {
    this.elemento = elemento;
    this.izquierdo = izquierdo;
    this.derecho = derecho;
  }

  public Nodo(Comparable<?> elemento) {
    this(elemento, null, null);
  }

  public Comparable<?> getElemento() {
    return this.elemento;
  }

  public void setElemento(Comparable<?> elemento) {
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

}
