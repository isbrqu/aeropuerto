package conjuntistas.ArbolAVL;
import conjuntistas.ArbolAVL.test.RotacionSimple;
import conjuntistas.ArbolAVL.test.RotacionDoble;
import conjuntistas.ArbolAVL.test.TestInsertar;
import conjuntistas.ArbolAVL.test.TestEliminar;
import conjuntistas.ArbolAVL.test.CrearArbol;

public class TestAVL {

  public static void main(String[] args) throws Exception {
    TestEliminar.RR();
    TestEliminar.LR();
    TestEliminar.LRR();
    TestEliminar.RLR();
    TestEliminar.LRR_RLR();
    TestEliminar.RLR_LRR();
  }

}
