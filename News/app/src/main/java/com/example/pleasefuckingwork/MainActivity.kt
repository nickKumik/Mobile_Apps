package com.example.pleasefuckingwork

import android.R
import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuCompat
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myToolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolbar)

        val tabLayout : TabLayout = findViewById(R.id.genres)
        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = TabAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) {tab, index ->
            tab.text = when(index){
                0 -> "Top"
                1 -> "Recommend"
                2 -> "Latest"
                else -> throw NotFoundException("position not found")
            }
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_layout,menu)

        if (menu != null)
            MenuCompat.setGroupDividerEnabled(menu, true)
        return super.onCreateOptionsMenu(menu)
    }


    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //when (item.itemId) {
            //R.id.refesh -> {

            // Signal SwipeRefreshLayout to start the progress indicator
            //mySwipeRefreshLayout.isRefreshing = true

            // Start the refresh background task.
            // This method calls setRefreshing(false) when it's finished.
            //val temp = findViewById<ViewPager2>(R.id.viewPager).findFragment<NewsListFrag>().topRefresh()
            //val fm: FragmentManager = supportFragmentManager //if added by xml

            //val fragment: NewsListFrag =
            //fm.findFragmentById(R.id.) as YourFragmentClass
            //fragment.yourPublicMethod()

            //return true

            //}
            //R.id.search -> {
            //return true
            // }
            //}
            //return super.onOptionsItemSelected(item)
        //}
    //}




}