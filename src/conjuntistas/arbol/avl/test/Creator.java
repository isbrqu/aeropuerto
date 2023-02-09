package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Pila;

public class Creator {

  public static void main(String[] args) {
    // sequence("10010");
    // sysou
  }

  public static NodoAVL base(String c) {
    return (c.equals("0")) ? null : new NodoAVL(null);
  }

  public static NodoAVL sequence(String[] sequence) {
    boolean flag = true;
    NodoAVL root = null;
    NodoAVL child = null;
    String c;
    for (int i = 0; i < sequence.length; i++) {
      c = sequence[i];
      if (flag) {
        root = base(c);
        flag = false;
      } else {
        child = root;
        root = new NodoAVL(null, child, base(c));
      }
    }
    return root;
  }

  // public static NodoAVL root(String pattern) {
  //   String binaries = "01";
  //   String bracket = "()";
  //   String c;
  //   boolean flag = true;
  //   NodoAVL root = null;
  //   NodoAVL child = null;
  //   Pila tokens = new Pila();
  //   String token;
  //   String sequence;
  //   for (int i = 0; i < pattern.length(); i++) {
  //     c = Character.toString(pattern.charAt(i));
  //     token = (String) tokens.obtenerTope();
  //     if ("01(".contains(token)) {
  //       tokens.apilar(token);
  //     } else if (token.equals(")")) {
  //       while (tokens.obtenerTope().equals("(")) {
  //         sequence += (String) tokens.obtenerTope();
  //         tokens.desapilar();
  //       }
  //       tokens.desapilar();
  //     }
  //   }
  //   return root;
  // }

}
