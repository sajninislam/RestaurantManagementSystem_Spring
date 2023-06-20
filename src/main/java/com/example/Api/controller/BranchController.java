package com.example.Api.controller;


import com.example.Api.model.BranchModel;
import com.example.Api.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class BranchController {


    @Autowired
    BranchService branchService;
    @GetMapping("/getBranch")
    public List<BranchModel> getAll(){
        return branchService.getAll();
    }

    @PostMapping("/postBranch")
    public void newPost(@RequestBody BranchModel branchModel) {
        branchService.save(branchModel);
    }


    @PutMapping("/updateBranch")
    public void update(@RequestBody BranchModel branchModel){
        branchService.save(branchModel);
    }

    @DeleteMapping("/deleteBranch/{id}")
    public void deletes(@PathVariable("id") Long id){
        branchService.del(id);
    }



    @GetMapping("/getBranch/{id}")
    public BranchModel getById(@PathVariable("id") Long id){
        return branchService.getById(id);
    }


    @GetMapping("/distanceCount")
    public static double distance(@RequestParam(value = "lat1") double lat1,@RequestParam(value = "lon1") double lon1,@RequestParam(value = "lat2") double lat2,@RequestParam(value = "lon2") double lon2,@RequestParam(value = "unit") String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                //dist = dist * 1.609344;
                dist = dist * 1.969344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }


}
