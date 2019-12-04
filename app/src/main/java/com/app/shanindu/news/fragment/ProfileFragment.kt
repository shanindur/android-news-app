package com.app.shanindu.news.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.shanindu.news.R


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)


//        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
//        lyt_progress = view.findViewById<LinearLayout>(R.id.lyt_progress)
//        lyt_connection = view.findViewById<LinearLayout>(R.id.lyt_connection)
//        btnRetry = view.findViewById<Button>(R.id.btn_retry)


        // Inflate the layout for this fragment
        return view
    }


}// Required empty public constructor
