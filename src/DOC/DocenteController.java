package DOC;

public class DocenteController {

    private DocenteModel dModel;


    public void passarParametros(objDadosDocente p_obj){
        this.dModel = new DocenteModel(p_obj);

    }

}
