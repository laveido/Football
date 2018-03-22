package com.sis.Service;

import com.sis.Dao.TeamDao;
import com.sis.Entity.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeamDao teamDao;

    public Collection<Team> getTeams() {
        return teamDao.getTeams();
    }

    public Team getTeamById(int id) throws IllegalStateException {
        Team teamById = new Team();
        try {
            teamById = teamDao.getTeamById(id);
        } catch (IllegalStateException exception) {
            throw exception;
        }
        return teamById;
    }

    public Collection<Team> getSortedTeam() {
        return teamDao.getSortedTeam();
    }
}
