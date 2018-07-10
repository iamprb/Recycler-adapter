package me.pranay.drawit.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*
import me.pranay.drawit.R
import me.pranay.drawit.adapter.DashboardAdapter


class DashboardFragment : Fragment() {


    val articles :List<String> = listOf("Few Things never Chnage","Kotlin waves bye bye to java",
            "Little basics of kotlin","Espresso: An UI automator","Integration of android app with visual studio app center",
            "Android Development: Kotlin","Run time permission:Kotlin","Singleton pattern:Kotlin","Factory pattern:kotlin",
            "MultiThreading: kotlin"
            )
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<DashboardAdapter.RecyclerViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override  fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutManager= LinearLayoutManager(activity)
        recycler_view.layoutManager= layoutManager
        adapter=DashboardAdapter(articles,this@DashboardFragment.activity as Context)
        recycler_view.adapter = adapter
    }

   private object Holder{
       val INSTANCE = DashboardFragment()
   }
    companion object {
        val instance : DashboardFragment by lazy { Holder.INSTANCE }
    }
}
