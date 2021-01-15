package com.example.soccereleven.match

import com.example.soccereleven.api.APIRepository
import com.example.soccereleven.api.TheSportDb
import com.example.soccereleven.model.MatchResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MatchPresenter(
    private val view: MatchView,
    private val apiRepo: APIRepository,
    private val gson: Gson
) {

    fun getLastMatchList(leagueId : String?){
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getLastMatch(leagueId)).await(), MatchResponse::class.java)
            view.hideLoading()
            data.events?.let { view.showMatchList(it) }
        }
    }

    fun getNextMatchList(leagueId : String?){
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.getNextMatch(leagueId)).await(), MatchResponse::class.java)
            view.hideLoading()
            data.events?.let { view.showMatchList(it) }
        }
    }

//    fun getLeagues(){
//        view.showLoading()
//
//        GlobalScope.launch(Dispatchers.Main){
//            val data = gson.fromJson(apiRepo.doRequest(
//                APIService.getLeague()).await(), LeagueResponse::class.java)
//            view.hideLoading()
//            data.leagues?.let { view.showLeagueList(it) }
//        }
//    }
//    error cause get non-soccer sport, change to static string array
}