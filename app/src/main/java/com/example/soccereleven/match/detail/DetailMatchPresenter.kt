package com.example.soccereleven.match.detail

import com.example.soccereleven.api.APIRepository
import com.example.soccereleven.api.TheSportDb
import com.example.soccereleven.model.MatchResponse
import com.example.soccereleven.model.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailMatchPresenter (
    private val view: DetailMatchView,
    private val apiRepo: APIRepository,
    private val gson: Gson
){
    fun getMatchDetail(eventId : String?){
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getMatchDetail(eventId)).await(), MatchResponse::class.java)

            data.events?.let { view.showMatchDetail(it) }
        }
    }

    fun getHomeLogo(teamId : String?){
//        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getTeamDetail(teamId)).await(), TeamResponse::class.java)

//            view.hideLoading()
            view.showHomeLogoTeam(data.teams)
        }
    }

    fun getAwayLogo(teamId : String?){
//        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getTeamDetail(teamId)).await(), TeamResponse::class.java)

//            view.hideLoading()
            view.showAwayLogoTeam(data.teams)
        }
    }
}