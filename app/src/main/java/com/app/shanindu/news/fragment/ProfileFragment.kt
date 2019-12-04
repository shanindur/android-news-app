package com.app.shanindu.news.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.app.shanindu.news.R


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

//        recyclerView = view.findViewById<ImageView>(R.id.profile_image)
//        lyt_progress = view.findViewById<LinearLayout>(R.id.lyt_progress)
//        lyt_connection = view.findViewById<LinearLayout>(R.id.lyt_connection)
//        btnRetry = view.findViewById<Button>(R.id.btn_retry)

        // Inflate the layout for this fragment
        return view
    }

}// Required empty public constructor
