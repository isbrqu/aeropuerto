package test;

import java.util.LinkedList;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class Utils {

  public static void llenar(Cola cola, String texto) {
    cola.vaciar();
    for (int i = 0; i < texto.length(); i++)
      cola.poner(texto.charAt(i));
  }

  public static void llenar(Cola cola, int[] arr) {
    cola.vaciar();
    for (int i = 0; i < arr.length; i++)
      cola.poner(arr[i]);
  }

  public static void llenar(Pila pila, String texto) {
    pila.vaciar();
    for (int i = 0; i < texto.length(); i++)
      pila.apilar(texto.charAt(i));
  }

  public static void llenar(Pila pila, int[] arr) {
    pila.vaciar();
    for (int i = 0; i < arr.length; i++)
      pila.apilar(arr[i]);
  }

  public static void llenar(Lista lista, String texto) {
    lista.vaciar();
    for (int i = 0; i < texto.length(); i++)
      lista.insertar(texto.charAt(i), i + 1);
  }

  public static void llenar(Lista lista, int[] arr) {
    lista.vaciar();
    for (int i = 0; i < arr.length; i++)
      lista.insertar(arr[i], i + 1);
  }

  public static Object[] variations(String[] alphabet, int length) {
    LinkedList<Integer> contador = new LinkedList<Integer>();
    LinkedList<String[]> result = new LinkedList<String[]>();
    String[] variation;
    int base = alphabet.length;
    int i = 0;
    int v = 0;
    while (contador.size() <= length) {
      if (i == contador.size()) {
        contador.add(0);
        if (contador.size() <= length) {
          variation = new String[contador.size()];
          for (int j = 0; j < contador.size(); j++)
            variation[j] = alphabet[contador.get(j)];
          result.add(variation);
        }
        i = 0;
      } else {
        v = contador.get(i) + 1;
        if (v < base) {
          contador.set(i, v);
          variation = new String[contador.size()];
          for (int j = 0; j < contador.size(); j++)
            variation[j] = alphabet[contador.get(j)];
          result.add(variation);
          if (i > 0)
            i = 0;
        } else {
          contador.set(i, 0);
          i++;
        }
      }
    }
    return result.toArray();
  }
}
