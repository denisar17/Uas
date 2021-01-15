package com.example.soccereleven.search

import com.example.soccereleven.model.Match

interface SearchView {
    fun showLoading()
    fun hideLoading()
    fun showSearchMatch(matches: List<Match>?)
}