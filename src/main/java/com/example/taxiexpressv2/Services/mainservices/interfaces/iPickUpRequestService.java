package com.example.taxiexpressv2.Services.mainservices.interfaces;

import com.example.taxiexpressv2.Entities.PickUpRequest;
import com.example.taxiexpressv2.Services.BaseServiceInterface;

import java.util.Optional;

public interface iPickUpRequestService extends BaseServiceInterface<PickUpRequest, Integer> {

    public Optional<PickUpRequest> retrieveTaxi(Integer idpickup);
}
