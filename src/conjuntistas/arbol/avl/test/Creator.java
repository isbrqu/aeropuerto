package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Pila;
import java.util.Arrays;

public class Creator {

  public static void main(String[] args) {
    // sequence("10010");
    // System.out.println(Arrays.toString("hola".split("")));
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

  public static NodoAVL root(String[] pattern) {
    String binaries = "01";
    String bracket = "()";
    String c;
    boolean flag = true;
    NodoAVL root = null;
    NodoAVL child = null;
    Pila tokens = new Pila();
    String sequence = "";
    String token = null;
    for (int i = 0; i < pattern.length; i++) {
      c = pattern[i];
      if (token == null || "01(".contains(token)) {
        tokens.apilar(c);
      } else if (token.equals(")")) {
        while (token != null || !token.equals("(")) {
          sequence += (String) tokens.obtenerTope();
          tokens.desapilar();
          token = (String) tokens.obtenerTope();
        }
        if (root == null) {
          root = sequence(sequence.split(""));
        } else {
          child = root;
          root = new NodoAVL(null, child, sequence(sequence.split("")));
        }
        tokens.desapilar();
      }
      token = (String) tokens.obtenerTope();
    }
    while (tokens.obtenerTope() != null) {
      sequence += (String) tokens.obtenerTope();
      tokens.desapilar();
    }
    if (root == null) {
      root = sequence(sequence.split(""));
    } else {
      child = root;
      root = new NodoAVL(null, child, sequence(sequence.split("")));
    }
    tokens.desapilar();
    return root;
  }

}
