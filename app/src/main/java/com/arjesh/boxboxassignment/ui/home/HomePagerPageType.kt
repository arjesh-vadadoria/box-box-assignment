package com.arjesh.boxboxassignment.ui.home

enum class HomePagerPageType(val pageIndex: Int) {
    WinnerDriver(pageIndex = 0),
    CommunityPage(pageIndex = 1), ;

    companion object {
        fun fromIndex(index: Int): HomePagerPageType {
            return entries.firstOrNull { it.pageIndex == index } ?: WinnerDriver
        }
    }
}