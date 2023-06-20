package com.example.Api.controller;
import com.example.Api.dto.BookcusDTO;
import com.example.Api.model.Bookcus;
import com.example.Api.service.EmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class EmpController {
//    @Autowired
//    myRepository repository;
    @Autowired
    EmpService empService;
    @PostMapping("/posts")
    public void save(@RequestBody Bookcus bookcusDTO){
//        if (bookcusDTO != null){
//            Bookcus bookcus = new Bookcus();
//            BeanUtils.copyProperties(bookcusDTO, bookcus);
//            empService.save(bookcus);
//        }
        empService.save(bookcusDTO);

    }




//    @PutMapping("/posts")
//    public void update( @RequestBody Post post){
//        service.save(post);
//    }

    @PutMapping("/posts")
    public void update( @RequestBody BookcusDTO bookcusDTO){
        if (bookcusDTO != null){
            Bookcus bookcus = new Bookcus();
            BeanUtils.copyProperties(bookcusDTO, bookcus);
            empService.save(bookcus);
        }
    }




//    @GetMapping("/posts")
//    List<PostDto> all(){return service.findAll();}


    @GetMapping("/posts")
    List<Bookcus> all() {
return empService.All();
//        List<Bookcus> posts = empService.findAll();
//        List<BookcusDTO> postDtoList = new ArrayList<>();
//        for (Bookcus post:posts
//        ) {
//            BookcusDTO postDto = new BookcusDTO();
//            BeanUtils.copyProperties(post, postDto);
//            postDtoList.add(postDto);
//        }
//        return postDtoList;
    }






    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable("id") Long id){ empService.delete(id);}







//    @GetMapping("/posts/{id}")
//    public Post get(@PathVariable("id") Long id){ return service.getById(id);}


    @GetMapping("/posts/{id}")
    public BookcusDTO getById(@PathVariable("id") Long id){
        Bookcus bookcus;
        bookcus = empService.getById(id);
        if(bookcus.getId() !=null){
            BookcusDTO cusDto = new BookcusDTO();
            BeanUtils.copyProperties(bookcus, cusDto);
            return cusDto;
        }
        return null;
    }




//    ---------aaaaaa-----


//    @GetMapping("/post")
//    public List<entity> getAll(){
//        return repository.findAll();
//    }
//
//    @PostMapping("/post")
//    public void newPost(@RequestBody entity en) {
//        ser.save(en);
//    }
//
//
//    @PutMapping("/post")
//    public void update(@RequestBody entity en){
//        ser.save(en);
//    }
//
//    @DeleteMapping("/post/{id}")
//    public void dele(@PathVariable("id") Long id){
//        ser.del(id);
//    }
//
//    @GetMapping("/post/{id}")
//    public entity getById(@PathVariable("id") Long id){
//        return ser.getById(id);
//    }

}
