package com.model.modelTransformation.controller;

import com.model.modelTransformation.entity.TransformationModel;
import com.model.modelTransformation.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xpwu on 2019/6/18.
 */
@Controller
public class ModelController {

    @Autowired
    private ModelService service;

    @RequestMapping(value = "/models")
    public ModelAndView showModelList(Model model) {

        List<TransformationModel> modelLists = service.showModelList();
        model.addAttribute("modelLists",modelLists);
        return new ModelAndView("/models.html","models",model);
    }

    @ResponseBody
    @RequestMapping(value = "/show/{modelName}")
    public ModelAndView queryModelByName(Model model,@PathVariable("modelName") String modelName) {
        //System.out.println(modelName);
        TransformationModel transformationModel = service.queryByModelname(modelName);
        System.out.println(transformationModel.getModelObjPath());
        model.addAttribute("transformationModel",transformationModel);
        return new ModelAndView("/show.html","show",model);
    }
}