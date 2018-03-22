package com.sis.Controller;

import com.sis.Entity.Team;
import com.sis.Service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = TeamController.class, secure = false)
public class TeamControllerTest {

    Team team = new Team("Liverpool F.C.", "Liverpool", "L_Owner", 1561, 37, new Date());

    @MockBean
    private TeamService teamService;

    @Test
    public void getTeamById() throws Exception {
        Mockito.when(teamService.getTeamById(Mockito.anyInt())).thenReturn(team);

        Team expected = teamService.getTeamById(3);
        JSONAssert.assertEquals(expected.getName(), "Liverpool F.C.", false);
    }
}
