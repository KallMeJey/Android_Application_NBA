package com.example.nba.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nba.R
import com.example.nba.presentation.Singletons
import com.example.nba.presentation.api.NbaApi
import com.example.nba.presentation.api.NbaListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NbaListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView
    private val adapter=NbaAdapter(listOf(), ::onClickedTeam)



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
            layoutManager=LinearLayoutManager(context)
            adapter=this@NbaListFragment.adapter
        }



        Singletons.nbaApi.getTeamList().enqueue(object : Callback<NbaListResponse>{
            override fun onResponse(call: Call<NbaListResponse>, response: Response<NbaListResponse>) {
                if (response.isSuccessful && response.body()!=null){
                   val nbaResponse:NbaListResponse= response.body()!!
                    adapter.updateList(nbaResponse.data)
                }
            }

            override fun onFailure(call: Call<NbaListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        val weatherList: ArrayList<String> = arrayListOf<String>().apply {
            add("Paris")
            add("London")
            add("Mumbai")
        }




    }
    private fun onClickedTeam(id: Int) {
        findNavController().navigate(R.id.navigateToNbaDetailFragment, bundleOf(
                "NbaID" to (id+1)
        ))


    }
}