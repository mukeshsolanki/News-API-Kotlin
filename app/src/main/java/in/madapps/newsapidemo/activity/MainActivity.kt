package `in`.madapps.newsapidemo.activity

import `in`.madapps.newsapidemo.R
import `in`.madapps.newsapidemo.adapter.ViewPagerAdapter
import `in`.madapps.newsapidemo.fragment.EverythingFragment
import `in`.madapps.newsapidemo.fragment.SourcesFragment
import `in`.madapps.newsapidemo.fragment.TopHeadlinesFragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var sourceFragment: SourcesFragment? = null
    var topHeadlinesFragment: TopHeadlinesFragment? = null
    var everythingFragment: EverythingFragment? = null
    var prevMenuItem: MenuItem? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem!!.isChecked = false
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false
                }
                bottomNavigationView.menu.getItem(position).isChecked = true
                prevMenuItem = bottomNavigationView.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        val adapter = ViewPagerAdapter(supportFragmentManager)
        sourceFragment = SourcesFragment()
        topHeadlinesFragment = TopHeadlinesFragment()
        everythingFragment = EverythingFragment()
        adapter.addFragment(sourceFragment!!)
        adapter.addFragment(topHeadlinesFragment!!)
        adapter.addFragment(everythingFragment!!)
        viewPager.adapter = adapter
    }

    private fun setupNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.sources -> viewPager.currentItem = 0
                R.id.topHeadlines -> viewPager.currentItem = 1
                R.id.everything -> viewPager.currentItem = 2
            }
            false
        }
    }
}
