package eu.qnh.baseball.service;

import eu.qnh.baseball.model.Team;
import eu.qnh.baseball.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team save(Team team) {
        return this.teamRepository.save(team);
    }
}
