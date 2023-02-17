package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Pila;
import java.util.Arrays;

public class Creator {

  public static int index;

  public static void main(String[] args) {
    System.out.println("test");
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

  public static NodoAVL generate(String pattern) {
    index = 0;
    return root(pattern);
  }

  public static NodoAVL root(String pattern) {
    NodoAVL node = null;
    NodoAVL child = null;
    boolean flag = false;
    while (index < pattern.length()) {
      char token = pattern.charAt(index);
      if (token == '0' || token == '1') {
        if (flag) {
          child = node;
          node = (token == '0') ? null : new NodoAVL(null);
          node = new NodoAVL(null, child, node);
        } else {
          node = (token == '0') ? null : new NodoAVL(null);
          flag = true;
        }
        index++;
      } else if (token == '(') {
        index++;
        if (flag) {
          child = node;
          node = root(pattern);
          node = new NodoAVL(null, child, node);
        } else {
          node = root(pattern);
          flag = true;
        }
      } else if (token == ')') {
        index++;
        break;
      }
    }
    return node;
  }

}
