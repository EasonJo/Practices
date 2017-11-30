package com.hencoder.hencoderpracticedraw7

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager
    private var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.layout.sample_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice_argb_evaluator))
        pageModels.add(PageModel(R.layout.sample_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator))
        pageModels.add(PageModel(R.layout.sample_of_object, R.string.title_of_object, R.layout.practice_of_object))
        pageModels.add(PageModel(R.layout.sample_property_values_holder, R.string.title_property_values_holder, R.layout.practice_property_values_holder))
        pageModels.add(PageModel(R.layout.sample_animator_set, R.string.title_animator_set, R.layout.practice_animator_set))
        pageModels.add(PageModel(R.layout.sample_keyframe, R.string.title_keyframe, R.layout.practice_keyframe))
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    private inner class PageModel internal constructor(@param:LayoutRes @field:LayoutRes internal var sampleLayoutRes: Int, @param:StringRes @field:StringRes internal var titleRes: Int, @param:LayoutRes @field:LayoutRes internal var practiceLayoutRes: Int)
}
