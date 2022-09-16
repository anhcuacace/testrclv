package com.codefresher.gapotest.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codefresher.gapotest.ui.account.AccountFragment
import com.codefresher.gapotest.ui.calendar.CalendarFragment
import com.codefresher.gapotest.ui.home.HomeFragment
import com.codefresher.gapotest.ui.messenger.MessengerFragment
import com.codefresher.gapotest.ui.notice.NoticeFragment
import com.codefresher.gapotest.ui.people.PeopleFragment

class ViewPagerAdapter(activity: FragmentActivity, private val tabCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment
    {
        return when (position)
        {
            0 -> HomeFragment()
            1 -> PeopleFragment()
            2 -> MessengerFragment()
            3 -> NoticeFragment()
            4 -> CalendarFragment()
            5 -> AccountFragment()
            else -> HomeFragment()
        }
    }
}