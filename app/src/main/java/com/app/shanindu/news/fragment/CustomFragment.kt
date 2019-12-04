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
class CustomFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_custom, container, false)


//        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
//        lyt_progress = view.findViewById<LinearLayout>(R.id.lyt_progress)
//        lyt_connection = view.findViewById<LinearLayout>(R.id.lyt_connection)
//        btnRetry = view.findViewById<Button>(R.id.btn_retry)


        // Inflate the layout for this fragment
        return view
    }

    //    //fetching custom news from API
//    private fun fetchCustomData(user_id: String) {
//
////        lyt_progress.setVisibility(View.VISIBLE)
////        lyt_progress.setAlpha(1.0f)
////        recyclerView.setVisibility(View.GONE)
//
//
//        internetAvailability = InternetObserver.isConnectedToInternet(context)
//        if (internetAvailability) {
//// Instantiate the RequestQueue.
//            val queue = Volley.newRequestQueue(context)
//            val request = object :
//                    StringRequest(
//                            Request.Method.GET,
//                            SINGLE_USER_URL + user_id,
//                            object : Response.Listener<String> {
//                                override fun onResponse(response: String) {
//                                    Log.d("response", "" + response)
//                                    if (response == "") {
//                                        return
//                                    }
//                                    try {
//
//                                        val jObj = JSONObject(response)
//
//                                        val obj = jObj.getJSONObject("data")
//
//                                        var user: News = News(
//                                                obj.getString("id"),
//                                                obj.getString("first_name"),
//                                                obj.getString("last_name"),
//                                                obj.getString("email"),
//                                                obj.getString("avatar")
//                                        )
//
//
//                                    } catch (e: JSONException) {
//                                        e.printStackTrace()
//                                    }
//
//
//                                }
//                            },
//                            object : Response.ErrorListener {
//                                override fun onErrorResponse(error: VolleyError) {
//                                    // error in getting json
//                                    Log.e(TAG, "Error: " + error.message)
//
//
//                                }
//                            }) {
//
//
//            }
//            request.setRetryPolicy(
//                    DefaultRetryPolicy(
//                            60000,
//                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
//                    )
//            )
//            queue.add(request)
//
//        } else {
//
//            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_LONG).show()
//
//
//        }
//    }
//

    override fun onDetach() {
        super.onDetach()

    }
}// Required empty public constructor
