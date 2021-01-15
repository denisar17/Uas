package com.example.soccereleven.search

import com.example.soccereleven.api.APIRepository
import com.example.soccereleven.api.TheSportDb
import com.example.soccereleven.model.SearchResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchPresenter(
    private val view: SearchView,
    private val apiRepo: APIRepository,
    private val gson: Gson
) {
    fun getMatchBySearch(text : String?){
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(apiRepo.doRequest(
                TheSportDb.searchMatch(text)).await(), SearchResponse::class.java)
            view.hideLoading()
            data?.event.let { view.showSearchMatch(it) }
        }
    }
}