package com.example.soccereleven.team

import com.example.soccereleven.api.APIRepository
import com.example.soccereleven.api.TheSportDb
import com.example.soccereleven.model.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamPresenter(
    private val view: TeamView,
    private val apiRepo: APIRepository,
    private val gson: Gson
)  {
    fun getTeamsByLeague(leagueId : String?){
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getTeamsByLeague(leagueId)).await(), TeamResponse::class.java)
            view.hideLoading()
            data?.teams.let { view.showTeamList(it) }
        }
    }

    fun getTeamBySearch(text : String?){
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.searchTeam(text)).await(), TeamResponse::class.java)
            view.hideLoading()
            data?.teams.let { view.showTeamList(it) }
        }
    }


}