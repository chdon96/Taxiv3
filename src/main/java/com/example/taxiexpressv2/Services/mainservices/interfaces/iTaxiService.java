package com.example.taxiexpressv2.Services.mainservices.interfaces;

import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Services.BaseServiceInterface;

import java.util.List;
import java.util.Optional;

public interface iTaxiService extends BaseServiceInterface<Taxi, Integer> {
    public Taxi addTaxi(Taxi e);
    public void deleteTaxi(int idTaxi);
    List<Taxi> getAllTaxis();
    List<Taxi> retrieveAllTaxis();
    public Optional<Taxi> retrieveTaxi(Integer idTaxi);
}
