package conjuntistas.ArbolAVL;
import conjuntistas.ArbolAVL.test.RotacionSimple;
import conjuntistas.ArbolAVL.test.RotacionDoble;
import conjuntistas.ArbolAVL.test.TestInsertar;
import conjuntistas.ArbolAVL.test.TestEliminar;

public class TestAVL {

  public static void main(String[] args) throws Exception {
    TestEliminar.rotandoDerechaBalanceNeutroEnRaiz();
    TestEliminar.rotandoDerechaBalancePositivoEnRaiz();
    TestEliminar.rotandoDerechaBalanceNegativoEnRaiz();
    TestEliminar.rotandoDerechaBalancePositivo();
    TestEliminar.rotandoDerechaBalanceNegativo();
    TestEliminar.rotandoDerechaBalanceNeutro();
  }

}
