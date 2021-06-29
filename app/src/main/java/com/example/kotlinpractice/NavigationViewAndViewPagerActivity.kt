package com.example.kotlinpractice

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_navigationviewandviewpager.*


class NavigationViewAndViewPagerActivity:AppCompatActivity() {

    var viewList = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationviewandviewpager)

        viewList.add(layoutInflater.inflate(R.layout.fragment_home,null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_favorite,null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_profile,null))

        viewPager.adapter = pagerAdapter()

    }

    inner class pagerAdapter: PagerAdapter()                   //클래스 안에 만들기 때문에 inner키워드 사용. 밖에 빼도 되지만 viewList를 바로 사용하기 위해
    {
        override fun getCount() = viewList.size

        override fun isViewFromObject(view: View, `object`: Any) = view == `object`
        override fun instantiateItem(container: ViewGroup, position: Int): Any {            //페이지를 넘길 때마다 생성
            var curView = viewList[position]
            viewPager.addView(curView)
            return curView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewPager.removeView(`object` as View)
        }
    }
}