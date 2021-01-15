package com.example.soccereleven.team

import com.example.soccereleven.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(teams: List<Team>?)
}