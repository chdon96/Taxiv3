package com.example.taxiexpressv2.Repositories;

import com.example.taxiexpressv2.Entities.PickUpRequest;
import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Repositories.usr.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickUpRequestRepository  extends BaseRepository<PickUpRequest, Integer> {
}
