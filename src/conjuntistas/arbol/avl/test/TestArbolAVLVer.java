package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.avl.NodoAVL;
import conjuntistas.arbol.manipulador.Llenador;
import conjuntistas.arbol.avl.test.Creator;
import svgtree.Html;
import java.util.Arrays;
import test.Utils;

public class TestArbolAVLVer {

  private static final String[] batch = {
    "10(1(10))",
    "10((1)10)",
    "10((1)(10))",
    "(10(1(10)))",
    "(10((1)10))",
    "(10((1)(10)))",
    "(10)(1(10))",
    "(10)((1)10)",
    "(10)((1)(10))",
    "((10)(1(10)))",
    "((10)((1)10))",
    "((10)((1)(10)))",
    "1(0)(1(10))",
    "1(0)((1)10)",
    "1(0)((1)(10))",
    "(1(0)(1(10)))",
    "(1(0)((1)10))",
    "(1(0)((1)(10)))",
    "(1(0))(1(10))",
    "(1(0))((1)10)",
    "(1(0))((1)(10))",
    "((1(0))(1(10)))",
    "((1(0))((1)10))",
    "((1(0))((1)(10)))",
    "(1)0(1(10))",
    "(1)0((1)10)",
    "(1)0((1)(10))",
    "((1)0((1)10))",
    "((1)0(1(10)))",
    "((1)0((1)(10)))",
    "((1)0)(1(10))",
    "((1)0)((1)10)",
    "((1)0)((1)(10))",
    "(((1)0)((1)10))",
    "(((1)0)(1(10)))",
    "(((1)0)((1)(10)))",
    "(1)(0)(1(10))",
    "(1)(0)((1)10)",
    "(1)(0)((1)(10))",
    "((1)(0)((1)10))",
    "((1)(0)(1(10)))",
    "((1)(0)((1)(10)))",
    "((1)(0))(1(10))",
    "((1)(0))((1)10)",
    "((1)(0))((1)(10))",
    "(((1)(0))((1)10))",
    "(((1)(0))(1(10)))",
    "(((1)(0))((1)(10)))",
  }

  public static void main(String[] args) {
    try {
      ArbolAVL arbol = new ArbolAVL();
      String[] alphabet = {"0", "1"};
      Html html = new Html();
      NodoAVL nodo;
      Object[] variations = Utils.variations(alphabet, 3);
      Llenador llenador = new Llenador(arbol);
      for (Object variation : variations) {
        String[] instance = (String[]) variation;
        nodo = Creator.sequence(instance);
        arbol.setRaiz(nodo);
        llenador.rellenar();
        String name = Arrays.toString(instance);
        html.draw(arbol, name);
      }
      String filename = "out/arbol.html";
      html.save(filename);
      startTree(filename);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void startTree(String name) throws Exception {
    ProcessBuilder processBuilder = new ProcessBuilder();
    processBuilder.command("cmd.exe", "/c", "start " + name);
    Process p = processBuilder.start();
    System.out.println("Exito: " + p.waitFor());
  }

} 
