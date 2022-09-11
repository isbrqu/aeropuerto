package conjuntistas.ArbolAVL;
import conjuntistas.ArbolAVL.test.RotacionSimple;
import conjuntistas.ArbolAVL.test.TestInsertar;

public class TestAVL {

  public static void main(String[] args) throws Exception {
    TestInsertar.repetidoEnRaiz();
    TestInsertar.repetidoEnHijoDerechoRaiz();
    TestInsertar.repetidoEnHijoIzquierdoRaiz();
    RotacionSimple.derechaEnRaiz();
    RotacionSimple.derechaHijoIzquierdo();
    RotacionSimple.derechaHijoDerecho();
  }

}
