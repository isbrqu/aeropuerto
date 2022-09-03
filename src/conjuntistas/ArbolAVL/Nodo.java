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
        this.altura = Math.max((this.izquierdo == null) ? -1 : this.izquierdo.altura, (this.derecho == null) ? -1 : this.derecho.altura) + 1;
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

    public int calcularBalance() {
        return ((this.izquierdo == null) ? -1 : this.izquierdo.altura) - ((this.derecho == null) ? -1 : this.derecho.altura);
    }

}
