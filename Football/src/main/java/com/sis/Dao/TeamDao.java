package com.sis.Dao;

import com.sis.Entity.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class TeamDao {

    private static Map<Integer, Team> team = new TreeMap<Integer, Team>();

    static {

        team.put(1, new Team("Manchester United F.C.", "Manchester", "M_Owner", 1740, 32, new Date()));
        team.put(3, new Team("Liverpool F.C.", "Liverpool", "L_Owner", 1561, 37, new Date()));
        team.put(2, new Team("Arsenal F.C.", "London", "A_Owner", 1610, 26, new Date()));
        team.put(4, new Team("Chelsea F.C.", "Fulham", "C_Owner", 1430, 41, new Date()));
        team.put(5, new Team("Everton F.C.", "Liverpool", "E_Owner", 1540, 32, new Date()));
        team.put(6, new Team("Real madrid", "Madrid", "R_Owner", 1330, 38, new Date()));
        team.put(7, new Team("Leicester City F.C.", "leicester", "L_Owner", 1510, 52, new Date()));

    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Collection<Team> getTeams() {
        return team.values();
    }

    public Team getTeamById(int id) {
        if (!team.containsKey(id)) {
            throw new IllegalStateException();
        }
        return team.get(id);
    }

    public Collection<Team> getSortedTeam() {

        Map<Integer, Team> teamMap = new TreeMap<Integer, Team>();

        for (Map.Entry<Integer, Team> entry : team.entrySet()) {
            teamMap.put(entry.getValue().getCapacity(), entry.getValue());
        }
        return teamMap.values();
    }
}
