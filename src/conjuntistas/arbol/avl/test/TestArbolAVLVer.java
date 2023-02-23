package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.avl.NodoAVL;
import conjuntistas.arbol.manipulador.Llenador;
import conjuntistas.arbol.avl.test.Creator;
import svgtree.Html;
import java.util.Arrays;
import test.Utils;

public class TestArbolAVLVer {

  private static final String[] batch0 = {
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
  };

  private static final String[] batch1 = {
    "11",
    "1(10)",
    "(11)0",
    "0(11)",
    "10(1(10))",
    "10((1)10)",
    "((10)1)10",
    "(11)(11)",
    "10(((100))(1))",
    "10((100)()(1))",
  };

  private static final String[] baseBatch1 = {
    "0", "1"
  };

  private static final String[] baseBatch2 = {
    "(0)", "(1)"
  };

  public static void main(String[] args) {
    try {
      ArbolAVL arbol = new ArbolAVL();
      Llenador llenador = new Llenador(arbol);
      Html html = new Html();
      for (String pattern : batch1) {
        NodoAVL root = Creator.generate(pattern);
        arbol.setRaiz(root);
        llenador.rellenar();
        html.draw(arbol, pattern);
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
