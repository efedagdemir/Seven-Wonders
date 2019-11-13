package model;

public class ModelService {
    private static ModelService modelService;
    Card xyz;

    private ModelService(){}
    Card sezo;
    public static ModelService getInstance() {
        if(modelService == null){
            modelService = new ModelService();
        }
        return modelService;
    }
}