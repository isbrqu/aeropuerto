package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.avl.NodoAVL;

public class CrearArbol {

  public static void main(String[] args) throws Exception {
    NodoAVL raiz = rotacionMultiple(new String[] {"RR"});
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    System.out.println(arbol);
  }

  public static NodoAVL rotacionDerecha(NodoAVL hijo)
      throws Exception {
      // RR
      NodoAVL raiz = null;
      if (hijo == null) {
        raiz = inclinado(2, 1);
      } else { 
        int altura = hijo.getAltura();
        NodoAVL izquierdo = inclinado(altura + 1, 1);
        NodoAVL derecho = hijo;
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL rotacionIzquierda(NodoAVL hijo)
      throws Exception {
      // LR
      NodoAVL raiz = null;
      if (hijo == null) {
        raiz = inclinado(2, -1);
      } else { 
        int altura = hijo.getAltura();
        NodoAVL izquierdo = hijo;
        NodoAVL derecho = inclinado(altura + 1, -1);
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL rotacionIzquierdaDerecha(NodoAVL hijo)
      throws Exception {
      // LRR
      NodoAVL raiz = null;
      NodoAVL izquierdo = null;
      NodoAVL derecho = null;
      if (hijo == null) {
        izquierdo = inclinado(1, -1);
        derecho = inclinado(0, 1);
        raiz = new NodoAVL(null, izquierdo, derecho);
      } else { 
        int altura = hijo.getAltura();
        izquierdo = inclinado(altura + 1, -1);
        derecho = hijo;
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL rotacionDerechaIzquierda(NodoAVL hijo)
      throws Exception {
      // RLR
      NodoAVL raiz = null;
      NodoAVL izquierdo = null;
      NodoAVL derecho = null;
      if (hijo == null) {
        izquierdo = inclinado(0, -1);
        derecho = inclinado(1, 1);
        raiz = new NodoAVL(null, izquierdo, derecho);
      } else { 
        int altura = hijo.getAltura();
        izquierdo = hijo;
        derecho = inclinado(altura + 1, 1);
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL neutro(NodoAVL hijo, int inclinacion)
      throws Exception {
      // RLR
      NodoAVL raiz = null;
      NodoAVL izquierdo = null;
      NodoAVL derecho = null;
      if (hijo == null) {
        izquierdo = new NodoAVL(null);
        derecho = new NodoAVL(null);
        raiz = new NodoAVL(null, izquierdo, derecho);
      } else if (inclinacion == 1) { 
        int altura = hijo.getAltura();
        izquierdo = hijo;
        derecho = inclinado(altura - 1, 0);
        raiz = new NodoAVL(null, izquierdo, derecho);
      } else {
        int altura = hijo.getAltura();
        izquierdo = inclinado(altura - 1, 0);
        derecho = hijo;
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL semiNeutro(NodoAVL hijo, int inclinacion)
      throws Exception {
      // RLR
      NodoAVL raiz = null;
      NodoAVL izquierdo = null;
      NodoAVL derecho = null;
      if (hijo == null) {
        raiz = (inclinacion == 1) ? inclinado(1, 1) : inclinado(1, -1);
      } else if (inclinacion == 1) { 
        int altura = hijo.getAltura();
        izquierdo = inclinado(altura - 1, 1);
        derecho = hijo;
        raiz = new NodoAVL(null, izquierdo, derecho);
      } else {
        int altura = hijo.getAltura();
        izquierdo = hijo;
        derecho = inclinado(altura - 1, -1);
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL inclinado(int altura, int inclinacion)
      throws Exception {
      NodoAVL raiz = null;
      if (altura >= 0) {
        raiz = new NodoAVL(null);
        NodoAVL izquierdo = null;
        NodoAVL derecho = null;
        if (inclinacion == 0) {
          izquierdo = inclinado(altura - 1, 0);
          derecho = inclinado(altura - 1, 0);
        } else {
          // determinan si se debe restar -1 o -2 a la altura
          izquierdo = inclinado(altura + (inclinacion - 3) / 2, 1);
          derecho = inclinado(altura + (inclinacion + 3) / -2, -1);
        }
        raiz = new NodoAVL(null, izquierdo, derecho);
      }
      return raiz;
  }

  public static NodoAVL rotacionMultiple(String[] patron)
      throws Exception {
      NodoAVL raiz = null;
      NodoAVL izquierdo = null;
      NodoAVL derecho = null;
      NodoAVL hijo = null;
      for (String rotacion : patron) {
        switch (rotacion) {
          case "RR":
            raiz = rotacionDerecha(hijo);
            break;
          case "LR":
            raiz = rotacionIzquierda(hijo);
            break;
          case "LRR":
            raiz = rotacionIzquierdaDerecha(hijo);
            break;
          case "RLR":
            raiz = rotacionDerechaIzquierda(hijo);
            break;
          case "-L":
            raiz = neutro(hijo, 1);
            break;
          case "-R":
            raiz = neutro(hijo, -1);
            break;
          case "-":
            raiz = neutro(hijo, 0);
            break;
          case "L":
            raiz = semiNeutro(hijo, 1);
            break;
          case "R":
            raiz = semiNeutro(hijo, -1);
            break;
        }
        hijo = raiz;
      }
      return raiz;
  }

}
