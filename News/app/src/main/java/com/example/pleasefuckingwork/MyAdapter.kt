package com.example.pleasefuckingwork

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.koushikdutta.ion.Ion
import java.net.URL


class MyAdapter (private val imageModelArrayList: MutableList<News>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    /*
     * Inflate our views using the layout defined in row_layout.xml
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.row_layout, parent, false)

        return ViewHolder(v)
    }

    private val items = ArrayList<News>()
/*
    override fun getItemCountV2(): Int {
        return items.size
    }
*/
    /*
     * Bind the data to the child views of the ViewHolder
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = imageModelArrayList[position]
       /* val url = URL(info.imageURL)
        val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        */
        Ion.with(holder.imgView)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .load(info.imageURL.toString());
        //Glide.with(holder.itemView.context).load(info.imageURL).into(holder.imgView)
        //holder.imgView.setImageResource(R.drawable.rec5)
        holder.txtMsg.text = info.title
        holder.txtAuthor.text = info.author
        holder.txtDate.text = "bvhfbvheak"

        holder.layout.setOnClickListener{
            val newIntent = Intent(holder.itemView.context, ArticleActivity::class.java)
            newIntent.putExtra("URL",info.url)
            holder.itemView.context.startActivity(newIntent)
        }

    }

    fun getImageFromURL(url: String){


    }

    /*
     * Get the maximum size of the
     */
    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    /*
     * The parent class that handles layout inflation and child view use
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var imgView = itemView.findViewById<View>(R.id.icon) as ImageView
        var txtMsg = itemView.findViewById<View>(R.id.firstLine) as TextView
        var txtAuthor = itemView.findViewById<View>(R.id.author) as TextView
        var txtDate = itemView.findViewById<View>(R.id.date) as TextView
        var layout = itemView.findViewById<View>(R.id.layout) as ConstraintLayout
    }



    /*
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
            }
        }

     */
}



//var intent = Intent(itemView.context, TeamDetail::class.java)
//itemView.context.startActivity(intent)