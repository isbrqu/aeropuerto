package conjuntistas.arbol.test;
import conjuntistas.arbol.Nodo;
import conjuntistas.arbol.NodoAVL;

public class TestNodo {

  public static void main(String[] args) {
    System.out.println("Hola");
    Nodo a = new NodoAVL(1);
    Nodo b = new NodoAVL(2);
    Nodo c = new NodoAVL(1, a, b);
    System.out.println(c.getElemento());
    System.out.println(((NodoAVL) c).getAltura());
    System.out.println(((NodoAVL) c).getBalance());
    System.out.println(c.getDerecho());
    System.out.println(c.getIzquierdo());
  }

} 
