package com.example.pleasefuckingwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulalist.MyModel

class LatestFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_latest, container, false)

        val imageModelArrayList = mutableListOf<News>()

        val recyclerView = view.findViewById<View>(R.id.my_recycler_view) as RecyclerView // Bind to the recyclerview in the layout
        val mAdapter = MyAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter

        return view
    }
    private fun populateList(): ArrayList<MyModel> {
        val list = ArrayList<MyModel>()
        val myImageList = arrayOf(R.drawable.rec1,R.drawable.rec2,R.drawable.rec3,R.drawable.rec4,R.drawable.rec5)
        val myImageNameList = arrayOf(R.string.Rec1, R.string.Rec2, R.string.Rec3, R.string.Rec4, R.string.Rec5)
        val myAuthorList = arrayOf("Author: BBC","Author: BBC","Author: BBC","Author: BBC","Author: BBC")
        val myDateList = arrayOf("Now","Now","Now","Now","Now")
        for (i in 0..4) {
            val imageModel = MyModel()
            imageModel.setNames(getString(myImageNameList[i]))
            imageModel.setImages(myImageList[i])
            imageModel.setAuthor(myAuthorList[i])
            imageModel.setDate(myDateList[i])
            list.add(imageModel)
        }
        return list
    }
}