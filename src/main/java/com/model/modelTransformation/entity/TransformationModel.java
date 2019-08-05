package com.model.modelTransformation.entity;

public class TransformationModel {
    private int id;
    private String modelName;
    private String modelObjPath;
    private String modelMtlPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelObjPath() {
        return modelObjPath;
    }

    public void setModelObjPath(String modelObjPath) {
        this.modelObjPath = modelObjPath;
    }

    public String getModelMtlPath() {
        return modelMtlPath;
    }

    public void setModelMtlPath(String modelMtlPath) {
        this.modelMtlPath = modelMtlPath;
    }


}
