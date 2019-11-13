package model;

public class ModelService {
    private static ModelService modelService;
    Card xyz;

    private ModelService(){}

    public static ModelService getInstance() {
        if(modelService == null){
            modelService = new ModelService();
        }
        return modelService;
    }
}