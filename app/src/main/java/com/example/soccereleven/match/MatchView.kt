package com.example.soccereleven.match

import com.example.soccereleven.model.Match

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(events: List<Match>)
//    fun showLeagueList(league: List<League>)
}