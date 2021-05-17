package com.example.nba.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nba.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NbaListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView

    private val layoutManager=LinearLayoutManager(context)
    private val adapter=NbaAdapter(listOf())

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nba_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.nba_recyclerview)
        recyclerView.apply {
            layoutManager=this@NbaListFragment.layoutManager
            adapter=this@NbaListFragment.adapter
        }

        val weatherList: ArrayList<String> = arrayListOf<String>().apply {
            add("Paris")
            add("London")
            add("Mumbai")
        }

        adapter.updateList(weatherList)


    }
}