package com.example.soccereleven.match.detail

import com.example.soccereleven.model.Match
import com.example.soccereleven.model.Team

interface DetailMatchView {
    fun showMatchDetail(match: List<Match>)
    fun showHomeLogoTeam(logoTeam: List<Team>?)
    fun showAwayLogoTeam(logoTeam: List<Team>?)
}