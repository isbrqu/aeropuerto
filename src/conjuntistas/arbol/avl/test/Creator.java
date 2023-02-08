package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Cola;

public class Creator {

  public static void main(String[] args) {
    root("10()");
  }

  public static NodoAVL base(String c) {
    return (c.equals("0")) ? null : new NodoAVL(null);
  }

  // public static NodoAVL base(String pattern) {
  //   NodoAVL root = null;
  //   switch (pattern) {
  //     case "0":
  //       root = null;
  //       break;
  //     case "1":
  //       root = new NodoAVL(null);
  //       break;
  //     case "01":
  //       root = new NodoAVL(null, null, new NodoAVL(null));
  //       break;
  //     case "10":
  //       root = new NodoAVL(null, new NodoAVL(null), null);
  //       break;
  //     case "11":
  //       root = new NodoAVL(null, new NodoAVL(null), new NodoAVL(null));
  //       break;
  //   }
  //   return root;
  // }
  // cerrar el laboratorio y cerrar las ventanas.

  public static NodoAVL root(String pattern) {
    String binaries = "01";
    String bracket = "()";
    String c;
    boolean flag = true;
    NodoAVL root = null;
    NodoAVL child = null;
    for (int i = 0; i < pattern.length(); i++) {
      c = Character.toString(pattern.charAt(i));
      if (binaries.contains(c)) {
        if (flag) {
          root = base(c);
          flag = false;
        } else {
          child = root;
          root = new NodoAVL(null, child, base(c));
        }
      } else if (bracket.contains(c)) {
        System.out.println("es ( o )");
      }
    }
    return root;
  }

  // public static NodoAVL root(String[] pattern, int i) {
  //   NodoAVL root = null;
  //   if (i < pattern.length) {
  //     NodoAVL left = base(pattern[i]);
  //     NodoAVL right = base(pattern[++i]);
  //     root = new NodoAVL(null, left, right);
  //   }
  //   return root;
  // }

}
