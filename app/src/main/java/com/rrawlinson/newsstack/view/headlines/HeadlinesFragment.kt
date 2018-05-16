package com.rrawlinson.newsstack.view.headlines


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rrawlinson.newsstack.R
import com.rrawlinson.newsstack.domain.HeadlineResponse
import com.rrawlinson.newsstack.domain.HeadlinesResponse
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_headlines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class HeadlinesFragment : DaggerFragment() {

    @Inject
    lateinit var retrofit: Retrofit

    var headlines: MutableList<HeadlineResponse> = ArrayList()

    var adapter: HeadlinesRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_headlines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Navigate with an action
//        view.findViewById<Button>(R.id.getLatestHeadlinesButton)
//                .setOnClickListener(createNavigateOnClickListener(R.id.action_headlinesFragment_to_headlineDetailFragment, null))

//        headlinesRecyclerView.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = HeadlinesRecyclerViewAdapter(headlines = headlines) {
//                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
//            }
//        }

        adapter = HeadlinesRecyclerViewAdapter(headlines) {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
        }

        headlinesRecyclerView.layoutManager = LinearLayoutManager(context)
        headlinesRecyclerView.adapter = adapter

        getLatestHeadlinesButton.setOnClickListener {
            getTopHeadlines()
        }
    }

    private fun getTopHeadlines() {
        val newsService = retrofit.create(NewsService::class.java)

        newsService.getTopHeadlines()
                .enqueue(object : Callback<HeadlinesResponse> {
                    override fun onFailure(call: Call<HeadlinesResponse>?, t: Throwable?) {
                        Log.d(TAG, t?.message)
                    }

                    override fun onResponse(call: Call<HeadlinesResponse>?, response: Response<HeadlinesResponse>?) {
                        response?.takeIf { it.isSuccessful }?.let {
                            val data = it.body()
//                            headlinesRecyclerView.adapter.refreshData(data)
                            if (data != null) {
                                adapter?.refreshData(data)
                            }
                        }
                    }
                })
    }

    interface NewsService {

        @GET("top-headlines?country=us")
        fun getTopHeadlines(): Call<HeadlinesResponse>
    }

    companion object {
        private val TAG = HeadlinesFragment::class.java.canonicalName
    }
}
