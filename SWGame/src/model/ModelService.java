package model;

public class ModelService {
    ModelService modelService;
    Card xyz;

    private ModelService(){}

    public ModelService getInstance(){
        if(modelService == null){
            modelService = new ModelService();
        }
        return modelService;
    }
}