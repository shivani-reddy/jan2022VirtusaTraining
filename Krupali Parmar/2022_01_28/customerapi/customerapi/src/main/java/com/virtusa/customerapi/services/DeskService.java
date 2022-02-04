package com.virtusa.customerapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.customerapi.models.Desk;
import com.virtusa.customerapi.repositories.DeskRepo;

import java.util.List;

@Service
public class DeskService {
    @Autowired
    private DeskRepo deskRepo;

    //insert
    public Desk addDesk(Desk desk){return this.deskRepo.save(desk);}

    //find by Id
    public Desk getDeskById(Long deskId){
        return this.deskRepo.findById(deskId).orElse(null);
    }

    //update
    public Desk updateDesk(Long deskId, Desk desk){
        Desk deskObj = this.getDeskById(deskId);
        if (deskObj!=null){

        }
        return this.deskRepo.save(desk);
    }

    //list all
    public List<Desk> getAllDesks(){return this.deskRepo.findAll();}

}