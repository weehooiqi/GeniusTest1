package com.example.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.Class.Course
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.about_us.*
import com.firebase.ui.database.FirebaseRecyclerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.course_list_layout.view.*


class AboutUs : Activity(){

    lateinit var mRecylerView : RecyclerView
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_us)


        mRecylerView = findViewById(R.id.myRecycler)
        mRecylerView.setLayoutManager(LinearLayoutManager(this))
        mDatabase = FirebaseDatabase.getInstance().getReference("Course")


        //addCourse("abc","test")
        logRecyclerView()

    }

    private fun logRecyclerView() {

        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<Course, CourseViewHolder>(

            Course::class.java,
            R.layout.course_list_layout,
            CourseViewHolder::class.java,
            mDatabase
        ) {

            override fun populateViewHolder(viewHolder : CourseViewHolder?, model: Course?, position:Int) {
                viewHolder?.itemView?.test?.text = model?.title
            }
        }

        mRecylerView.adapter = FirebaseRecyclerAdapter
    }

    class CourseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        init {

            itemView!!.setOnClickListener{

                val intent = Intent(itemView.context, MainActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    private fun addCourse(title: String, desc: String) {
        val course = Course(title, desc)
        mDatabase.child(title).setValue(course)
    }

}
