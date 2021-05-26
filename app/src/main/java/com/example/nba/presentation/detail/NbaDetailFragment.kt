package com.example.nba.presentation.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.nba.R
import com.example.nba.presentation.Singletons
import com.example.nba.presentation.api.NbaDetailResponse
import com.example.nba.presentation.api.NbaListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NbaDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nba_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName=view.findViewById(R.id.nba_detail_name)
        callApi()



    }

    private fun callApi() {
            val id:Int =arguments?.getInt("NbaID")?:-1
            Singletons.nbaApi.getTeamDetail(id).enqueue(object: Callback<NbaDetailResponse>{
                override fun onResponse(call: Call<NbaDetailResponse>, response: Response<NbaDetailResponse>) {

                    if (response.isSuccessful && response.body()!=null){
                        textViewName.text= response.body()!!.city
                    }

                }

                override fun onFailure(call: Call<NbaDetailResponse>, t: Throwable) {
                }

            })
    }


}



