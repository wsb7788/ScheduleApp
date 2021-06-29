package com.example.kotlinpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_navigationviewandviewpager.*


class NavigationViewAndViewPagerActivity:AppCompatActivity() {

    var viewList = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationviewandviewpager)



        viewList.add(layoutInflater.inflate(R.layout.fragment_home,null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_favorite,null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_profile,null))

        viewPager.adapter = ViewPagerAdapter(getViewList())

        fun getViewList(): ArrayList<Int> = arrayListOf<Int>(R.layout.fragment_home,R.layout.fragment_favorite,R.layout.fragment_profile)




    }

/*    inner class pagerAdapter: PagerAdapter()                   //클래스 안에 만들기 때문에 inner키워드 사용. 밖에 빼도 되지만 viewList를 바로 사용하기 위해
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
    }*/

    inner class ViewPageraAdapter(idolList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
        var item = idolList

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

        override fun getItemCount(): Int = item.size

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
            holder.idol.setImageResource(item[position])
        }

        inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
            (LayoutInflater.from(parent.context).inflate(R.layout.idol_list_item, parent, false)){

            val idol = itemView.imageView_idol!!
        }
    }

    inner class ViewPagerAdapter(viewList: ArrayList<Int>): RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewPagerAdapter.PagerViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }
}