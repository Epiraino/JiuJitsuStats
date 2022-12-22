package com.ep.jiujitsustats.repos;

import com.ep.jiujitsustats.dao.models.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public
class FighterService {

    private final FighterRepo fighterRepo;

    @Autowired
    public FighterService(FighterRepo fighterRepo) {

        this.fighterRepo = fighterRepo;
    }

    public Fighter createFighter(final Fighter fighter) {
        fighterRepo.save(fighter);
        return fighter;
    }
}
