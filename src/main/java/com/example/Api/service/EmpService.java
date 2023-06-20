package com.example.Api.service;
import com.example.Api.model.Bookcus;
import com.example.Api.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired

    MyRepository empRepo;


    public List<Bookcus>  All() {return empRepo.findAll();}

    public void save(Bookcus postNew) {
        if (postNew.getId()!= null){
            empRepo.findById(postNew.getId())
                    .map(old -> {
                        old.setName(postNew.getName());
                        old.setEmail(postNew.getEmail());
                        old.setPhnumber(postNew.getPhnumber());
                        old.setBookingDate(postNew.getBookingDate());
                        old.setBookingTime(postNew.getBookingTime());
                        old.setComingTime(postNew.getComingTime());
                        old.setGuest(postNew.getGuest());

                        return empRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return empRepo.save(postNew);
                    });
        }else {
            empRepo.save(postNew);
        }
    }

    public Bookcus getById(Long id) {return empRepo.findById(id).orElse(new Bookcus());}

    public void delete(Long id) {empRepo.deleteById(id);}




//    -----aaaaaa-----




//    public List<entity> getAll(){
//        return repo.findAll();
//    }
//    public void save(entity en){
//        if(en.getId()!=null){
//            repo.findById(en.getId()).map(old ->{
//                old.setName(en.getName());
//                old.setGender(en.getGender());
//                old.setCourse(en.getCourse());
//                old.setSsc(en.getSsc());
//                old.setHsc(en.getHsc());
//                old.setBsc(en.getBsc());
//                return repo.save(old);
//
//            }).orElseGet(() ->{
//                return repo.save(en);
//            });
//
//        }else {
//            repo.save(en);
//        }
//    }
//    public entity getById(Long id){
//        return repo.findById(id).orElse(new entity());
//    }
//
//    public void del(Long id){
//        repo.deleteById(id);
//    }
}
