package com.example.test.ui.course

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.test.CourseContent
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_course.view.*

class CourseFragment : Fragment() {

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        courseViewModel =
            ViewModelProviders.of(this).get(CourseViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_course, container, false)


        view.imageBtnComputerScience.setOnClickListener {
            val intent = Intent(activity, CourseContent ::class.java)
            startActivity(intent)
        }





        return view

    }
}