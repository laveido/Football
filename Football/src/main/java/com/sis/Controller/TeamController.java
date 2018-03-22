package com.sis.Controller;

import com.sis.Entity.Team;
import com.sis.Service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Team> getTeams() {
        logger.debug("Team details are extracted");
        return teamService.getTeams();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable("id") String id) throws NullPointerException, IllegalStateException {
        if (id == null) {
            logger.error("URL Parameter does not contain ID for searching");
            throw new NullPointerException();
        }
        try {
            return teamService.getTeamById(Integer.parseInt(id));
        } catch (IllegalStateException exception) {
            logger.error("ID entered is not available in repository");
            throw exception;
        }
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public Collection<Team> getSortedTeam() {
        logger.debug("Teams are listed in sorted order");
        return teamService.getSortedTeam();
    }
}
