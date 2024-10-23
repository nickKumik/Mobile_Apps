package com.example.pleasefuckingwork

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.clearFragmentResult
import androidx.recyclerview.widget.RecyclerView
import com.example.formulalist.MyModel
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion

class NewsListFrag : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var articles : MutableList<News>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        articles = mutableListOf<News>()

        recyclerView = view.findViewById<View>(R.id.my_recycler_view) as RecyclerView // Bind to the recyclerview in the layout
        val mAdapter = MyAdapter(articles)
        recyclerView.adapter = mAdapter
        Headlines()
        return view
    }

    fun topRefresh(){
        Headlines()
    }

    private fun Headlines (){
        Ion.with(this)
            .load("https://newsapi.org/v2/top-headlines?country=au&apiKey=c5211c407f874e0e8c45a1a2e682fb6c")
            .userAgent("Hello")
            .setHeader("API-Key","c5211c407f874e0e8c45a1a2e682fb6cv")
            .asJsonObject()
            .setCallback {e, result ->
                if (e != null){
                    Log.e("NewsData",e.stackTraceToString())
                }else{
                    articles.clear()
                    result.getAsJsonArray("articles").forEach{
                        val ele = it.asJsonObject
                        articles.add(News(getTitleVal(ele), getAuthorVal(ele), getURLVal(ele), getImgURLVal(ele)))
                    }

                   recyclerView.adapter?.notifyDataSetChanged()
                }
            }
    }

    private fun getTitleVal(jsonObject: JsonObject): String?{
        return checkJasonMember(jsonObject, "title")
    }
    private fun getAuthorVal(jsonObject: JsonObject): String?{
        return checkJasonMember(jsonObject, "Author")
    }
    private fun getURLVal(jsonObject: JsonObject): String?{
        return checkJasonMember(jsonObject, "url")
    }
    private fun getImgURLVal(jsonObject: JsonObject): String?{
        return checkJasonMember(jsonObject, "urlToImage")
    }

    private fun checkJasonMember(jsonObject: JsonObject, name: String): String?{
        val check = jsonObject.get(name)
        return if (check != null && !check.isJsonNull){
            check.asString
        }else {
            null
        }
    }
}