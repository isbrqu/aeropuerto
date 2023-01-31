package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.avl.test.TestArbolAVLInsertar;
import conjuntistas.arbol.avl.test.TestArbolAVLEliminar;
import svgtree.Tree;

public class TestArbolAVL {

  public static void main(String[] args) {
    try {
      // TEST BÁSICOS
      System.out.println("=== INSERTAR BÁSICOS CON ROTACIONES ===");
      // rotacion simple
      TestArbolAVLInsertar.derechaEnRaiz();
      TestArbolAVLInsertar.derechaHijoIzquierdo();
      TestArbolAVLInsertar.derechaHijoDerecho();
      TestArbolAVLInsertar.izquierdaEnRaiz();
      TestArbolAVLInsertar.izquierdaHijoIzquierdo();
      TestArbolAVLInsertar.izquierdaHijoDerecho();
      // rotacion doble
      TestArbolAVLInsertar.izquierdaDerechaEnRaiz();
      TestArbolAVLInsertar.izquierdaDerechaEnHijoIzquierdo();
      TestArbolAVLInsertar.izquierdaDerechaEnHijoDerecho();
      TestArbolAVLInsertar.derechaIzquierdaEnRaiz();
      TestArbolAVLInsertar.derechaIzquierdaEnHijoIzquierdo();
      TestArbolAVLInsertar.derechaIzquierdaEnHijoDerecho();
      // otras
      TestArbolAVLInsertar.repetidoIterativo();
      // TEST ELIMINAR BÁSICOS
      // TEST INSERTAR Y ELIMINAR 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} 
