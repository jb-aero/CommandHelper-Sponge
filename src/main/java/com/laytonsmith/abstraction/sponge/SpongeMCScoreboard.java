package com.laytonsmith.abstraction.sponge;

import com.laytonsmith.abstraction.MCObjective;
import com.laytonsmith.abstraction.MCOfflinePlayer;
import com.laytonsmith.abstraction.MCScore;
import com.laytonsmith.abstraction.MCScoreboard;
import com.laytonsmith.abstraction.MCTeam;
import com.laytonsmith.abstraction.enums.MCDisplaySlot;
import org.spongepowered.api.scoreboard.Scoreboard;

import java.util.Set;

public class SpongeMCScoreboard implements MCScoreboard {

	Scoreboard board;

	public SpongeMCScoreboard(Scoreboard build) {
		this.board = build;
	}

	@Override
	public void clearSlot(MCDisplaySlot mcDisplaySlot) {

	}

	@Override
	public MCObjective getObjective(MCDisplaySlot mcDisplaySlot) {
		return null;
	}

	@Override
	public MCObjective getObjective(String s) {
		return null;
	}

	@Override
	public Set<MCObjective> getObjectives() {
		return null;
	}

	@Override
	public Set<MCObjective> getObjectivesByCriteria(String s) {
		return null;
	}

	@Override
	public Set<String> getEntries() {
		return null;
	}

	@Override
	public MCTeam getPlayerTeam(String entry)
	{
		return null;
	}

	@Override
	public Set<MCScore> getScores(String s) {
		return null;
	}

	@Override
	public MCTeam getTeam(String s) {
		return null;
	}

	@Override
	public Set<MCTeam> getTeams() {
		return null;
	}

	@Override
	public MCObjective registerNewObjective(String s, String s1) {
		return null;
	}

	@Override
	public MCTeam registerNewTeam(String s) {
		return null;
	}

	@Override
	public void resetScores(String s) {

	}
}
