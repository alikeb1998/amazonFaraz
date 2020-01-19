package com.maktab.amazonfaraz.view.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.maktab.amazonfaraz.R
import com.maktab.amazonfaraz.view.fragments.AllProductFragment
import com.maktab.amazonfaraz.view.fragments.MenProductFragment
import com.maktab.amazonfaraz.view.fragments.WomenProductFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tabs: TabLayout
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = viewpager
        tabs = findViewById(R.id.tabs)
        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager, 0) {
            override fun getItem(position: Int): Fragment {
                when (position) {
                    0 -> return AllProductFragment()
                    1 -> return MenProductFragment()
                    else -> return WomenProductFragment()
                }
            }

            override fun getCount(): Int {
                return 3
            }

            override fun getPageTitle(position: Int): CharSequence? {
                lateinit var title: String
                when (position) {
                    0 -> title = "All"
                    1 -> title = "Mens"
                    2 -> title = "Womens"
                }
                return title
            }
        }
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark))
        tabs.setTabTextColors(Color.BLACK, getColor(R.color.yellowAmazon))
        tabs.setupWithViewPager(viewPager)
    }
}

