package com.rrawlinson.newsstack.view.headlines

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rrawlinson.newsstack.R
import com.rrawlinson.newsstack.domain.HeadlineResponse
import com.rrawlinson.newsstack.domain.HeadlinesResponse
import com.rrawlinson.newsstack.utils.inflate
import kotlinx.android.synthetic.main.headline_list_item.view.*

class HeadlinesRecyclerViewAdapter(private val headlines: MutableList<HeadlineResponse>, private val listener: (HeadlineResponse) -> Unit) : RecyclerView.Adapter<HeadlinesRecyclerViewAdapter.HeadlineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val view = parent.inflate(R.layout.headline_list_item)
        return HeadlineViewHolder(view)
    }

    override fun getItemCount(): Int = headlines.count()

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) =
            holder.bind(headlines[position], listener)

    fun refreshData(updatedList: HeadlinesResponse) {
        with(headlines) {
            clear()
            updatedList.articles?.let { addAll(it) }
            notifyDataSetChanged()
        }
    }

    class HeadlineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(headline: HeadlineResponse, listener: (HeadlineResponse) -> Unit) = with(itemView) {
            Glide.with(itemView)
                    .load(headline.urlToImage)
                    .into(headlineListItemImage)

            headlineListItemTitle.text = headline.title
            headlineListItemDescription.text = headline.description

            setOnClickListener {
                listener(headline)
            }
        }
    }
}