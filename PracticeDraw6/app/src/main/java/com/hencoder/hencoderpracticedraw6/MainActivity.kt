package com.hencoder.hencoderpracticedraw6

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager
    private var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.layout.sample_translation, R.string.title_translation, R.layout.practice_translation))
        pageModels.add(PageModel(R.layout.sample_rotation, R.string.title_rotation, R.layout.practice_rotation))
        pageModels.add(PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale))
        pageModels.add(PageModel(R.layout.sample_alpha, R.string.title_alpha, R.layout.practice_alpha))
        pageModels.add(PageModel(R.layout.sample_multi_properties, R.string.title_multi_properties, R.layout.practice_multi_properties))
        pageModels.add(PageModel(R.layout.sample_duration, R.string.title_duration, R.layout.practice_duration))
        pageModels.add(PageModel(R.layout.sample_interpolator, R.string.title_interpolator, R.layout.practice_interpolator))
        pageModels.add(PageModel(R.layout.sample_object_anomator, R.string.title_object_animator, R.layout.practice_object_animator))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.pager) as ViewPager
        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes)
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return getString(pageModels[position].titleRes)
            }
        }

        tabLayout = findViewById(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(pager)
    }

    private inner class PageModel(@LayoutRes var sampleLayoutRes: Int,
                                  @StringRes var titleRes: Int,
                                  @LayoutRes var practiceLayoutRes: Int)
}
