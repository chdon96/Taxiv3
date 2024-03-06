package com.example.taxiexpressv2.Services.mainservices;


import com.example.taxiexpressv2.Entities.PickUpRequest;
import com.example.taxiexpressv2.Repositories.PickUpRequestRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iPickUpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickUpRequestService implements iPickUpRequestService {

    @Autowired
    PickUpRequestRepository pickUpRequestRepository;
    @Override
    public List<PickUpRequest> retrieveAll() {
        return pickUpRequestRepository.findAll();
    }

    @Override
    public PickUpRequest add(PickUpRequest e) {
        return pickUpRequestRepository.save(e);
    }

    @Override
    public PickUpRequest update(PickUpRequest e) {
        return pickUpRequestRepository.save(e);
    }

    @Override
    public PickUpRequest retrieve(Integer integer) {
        return null;
    }

    @Override
    public Optional<PickUpRequest> retrieveTaxi(Integer idpickup) {
        return pickUpRequestRepository.findById(idpickup);
    }
    @Override
    public void remove(Integer integer) {

    }
}
