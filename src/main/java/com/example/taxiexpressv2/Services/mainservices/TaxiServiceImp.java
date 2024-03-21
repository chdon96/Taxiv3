package com.example.taxiexpressv2.Services.mainservices;


import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Repositories.TaxiRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiServiceImp implements iTaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public List<Taxi> retrieveAllTaxis() {

            return taxiRepository.findAll();
    }


    @Override
    public void deleteTaxi(int idTaxi) {
        Taxi taxi = taxiRepository.findById(idTaxi).get();
        //taxi.setState(state.DENIED);
        taxi.setStatus(false);
        taxiRepository.save(taxi);
    }

    @Override
    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    @Override
    public Taxi addTaxi(Taxi t) {
        return taxiRepository.save(t);

    }

    @Override
    public List<Taxi> retrieveAll() {

            return taxiRepository.findAll();    }

    @Override
    public Taxi add(Taxi e) {
        return taxiRepository.save(e);
    }

    @Override
    public Taxi update(Taxi e) {

        return taxiRepository.save(e);
    }

    @Override
    public Taxi retrieve(Integer integer) {
        return null;
    }

    @Override
    public Optional<Taxi> retrieveTaxi(Integer idTaxi) {
        return taxiRepository.findById(idTaxi);
    }

    @Override
    public void remove(Integer integer) {

    }
}
