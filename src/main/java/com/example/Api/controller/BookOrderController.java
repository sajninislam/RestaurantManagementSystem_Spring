package com.example.Api.controller;

import com.example.Api.model.BookOrder;
import com.example.Api.repository.BookOrerDaw;
import com.example.Api.service.BookOrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class BookOrderController {
@Autowired
BookOrerService bookOrderService;


    @Autowired
    BookOrerDaw bookOrerDaw;

    @PostMapping("/book")
    public void save(@RequestBody List<BookOrder> bookOrder, @RequestParam(value = "userName") String username ,
                     @RequestParam(value = "customerName") String customerName,
                     @RequestParam(value = "customerPhNu") String customerPhNu,
                     @RequestParam(value = "customerAddress") String customerAddress,
                     @RequestParam(value = "PaymentMethod") String PaymentMethod
//                     @RequestParam(value = "orderStatus") String OrderStatus)
    )


    {
//        if (bookcusDTO != null){
//            Bookcus bookcus = new Bookcus();
//            BeanUtils.copyProperties(bookcusDTO, bookcus);
//            empService.save(bookcus);
//        }
        bookOrderService.saveOrder(bookOrder, username, customerName, customerPhNu, customerAddress, PaymentMethod);
    }
//        @GetMapping("/book")
//    public List<BookOrder> getAll( @RequestParam(value = "userName") String username ){
//        return bookOrderService.getAlls(username);
//    }
    // get single value
@GetMapping("/{id}")
public BookOrder getSingleValue(@PathVariable("id") Long id  ){
    return bookOrderService.getSingle(id);
}
//    @GetMapping("/{id}")
//    public List<BookOrder> getSingleAll( @PathVariable("id") Long id ){
//        return bookOrderService.getSingleAlls();
//    }
    @GetMapping("/book")
    public List<BookOrder> getAll(@RequestParam(value = "orderStatus", required = false )String orderStatus,
                                  @RequestParam(value = "userName", required = false) String username ){
        return bookOrderService.getAlls(orderStatus,username);
    }

@GetMapping("/book1")
    public List<BookOrder > get(){
    return bookOrerDaw.findAll();
}




    //    @PostMapping("/Postcourier")
//    public void newPost(@RequestBody ProductInformation product, @RequestParam(value = "userName") String username) {
//        p_service.saveProduct(product, username);
//    }
//
//    @GetMapping("/getCourierList")
//    public List<ProductInformation> getAll(@RequestParam(value = "orderStatus", required = false) String orderStatus, @RequestParam(value = "userName", required = false) String username ){
//        return p_service.getAlls(orderStatus,username);
//    }




    @PutMapping("/")
    public void updates(@RequestBody BookOrder product){
        bookOrderService.updateOrder(product);
    }


}
