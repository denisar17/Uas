package com.example.soccereleven.team.detail

import com.example.soccereleven.model.Player

interface PlayerView {
    fun showLoading()
    fun hideLoading()
    fun showPlayerList(players: List<Player>)
}