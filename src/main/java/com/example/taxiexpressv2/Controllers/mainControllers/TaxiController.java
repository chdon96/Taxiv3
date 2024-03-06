package com.example.taxiexpressv2.Controllers.mainControllers;

import com.example.taxiexpressv2.Controllers.BaseController;
import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Repositories.TaxiRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/taxi")
public class TaxiController  extends BaseController<Taxi, Integer> {
    @Autowired
    private iTaxiService taxiService;

    @Autowired
    private TaxiRepository taxiRepository;


    @PostMapping("/addtaxi")
    private Taxi addTaxi( @RequestBody Taxi taxi){
        System.out.println(taxi);
        taxiService.addTaxi(taxi);
        //taxi.setCreatedAt();

        return taxi;
    }
    @GetMapping("get-taxis")
    public ResponseEntity getAllEvents() {
        List<Taxi> alltaxis = taxiService.getAllTaxis();
        return new ResponseEntity<>(alltaxis, HttpStatus.CREATED);
    }

    @GetMapping("gettaxi/{id}")
    public ResponseEntity retrieveTaxi(@PathVariable int id){

        System.out.println("ID"+id);
        Optional<Taxi> taxi = taxiService.retrieveTaxi(id);
        return new ResponseEntity<>(taxi, HttpStatus.CREATED);
    }

}
