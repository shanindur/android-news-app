package com.app.shanindu.news.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.app.shanindu.news.R
import com.app.shanindu.news.adapter.NewsAdapter
import com.app.shanindu.news.model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shanindu.app.news.helper.InternetObserver
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList


class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
    private val ALL_USER_URL = "https://reqres.in/api/users?page=2"
    private val SINGLE_USER_URL = "https://reqres.in/api/users/"
    private val HEADLINES_URL = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=7e34fe9b5e32418ebc3f42370f1458f3"

    private var recyclerView: RecyclerView? = null
    private var btnRetry: Button? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: NewsAdapter? = null
    private val newsList = ArrayList<News>()
    private var lyt_progress: LinearLayout? = null
    private var lyt_connection: LinearLayout? = null
    @Volatile
    private var internetAvailability: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val context = activity as Context

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        lyt_progress = view.findViewById<LinearLayout>(R.id.lyt_progress)
        lyt_connection = view.findViewById<LinearLayout>(R.id.lyt_connection)
        btnRetry = view.findViewById<Button>(R.id.btn_retry)




        initComponent(view)
        // Inflate the layout for this fragment
        return view
    }

    private fun initComponent(view: View) {

        // in content do not change the layout size of the RecyclerView
        recyclerView?.setHasFixedSize(true)

        // use a linear layout manager
        layoutManager = LinearLayoutManager(context)
        recyclerView?.setLayoutManager(layoutManager)

        // specify an adapter
        mAdapter = NewsAdapter(context, newsList)
        recyclerView?.setAdapter(mAdapter)

        fetchData()


        mAdapter?.SetOnItemClickListener(object : NewsAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int, obj: News) {
//                showDialogDetail(obj)
            }
        })
    }


    //fetching news from API
    private fun fetchData() {

        internetAvailability = InternetObserver.isConnectedToInternet(context)
        if (internetAvailability) {

            lyt_progress?.setVisibility(View.VISIBLE)
            lyt_progress?.setAlpha(1.0f)
            recyclerView?.setVisibility(View.GONE)
            lyt_connection?.setVisibility(View.GONE)

// Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(context)
            val request = object :
                    StringRequest(Request.Method.GET, HEADLINES_URL, object : Response.Listener<String> {
                        override fun onResponse(response: String) {
                            Log.d("response", "" + response)
                            if (response == "") {
                                return
                            }
                            try {

                                val jObj = JSONObject(response)
                                val news: List<News>

                                news = Gson().fromJson<List<News>>(
                                        jObj.getJSONArray("articles").toString(),
                                        object : TypeToken<List<News>>() {

                                        }.type
                                )

                                // adding users to user list
                                newsList.clear()
                                newsList.addAll(news)

                                // refreshing recycler view
                                mAdapter?.notifyDataSetChanged()

                                lyt_progress?.setVisibility(View.GONE)
                                recyclerView?.setAlpha(1.0f)
                                recyclerView?.setVisibility(View.VISIBLE)


                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }


                        }
                    }, object : Response.ErrorListener {
                        override fun onErrorResponse(error: VolleyError) {
                            // error in getting json
                            Log.e(TAG, "Error: " + error.message)


                        }
                    }) {


            }
            request.setRetryPolicy(
                    DefaultRetryPolicy(
                            60000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    )
            )
            queue.add(request)

        } else {
            lyt_connection?.setVisibility(View.VISIBLE)
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show()


        }
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


}