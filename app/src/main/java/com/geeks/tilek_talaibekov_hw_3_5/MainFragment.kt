package com.geeks.tilek_talaibekov_hw_3_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class MainFragment : Fragment() {


    private lateinit var tvNumber: TextView
    private lateinit var btnPress: Button
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        btnPress.setOnClickListener{
            if (btnPress.text == "+1"){
                if (counter < 10){
                    counter++
                } else{
                    btnPress.text = "-1"
                }
            } else {
               if (counter > 0) {
                   counter--
               } else{
                   openNextFragment()
               }
            }
            upDateCounterText()
        }
    }

    private fun upDateCounterText() {
        if(counter == 10){
            btnPress.text == "-1"
        }
        tvNumber.text = counter.toString()
    }
    private fun openNextFragment(){
        var number = tvNumber.text.toString()
        var bundle = Bundle()
        bundle.putString("key",number)
        val nextFragment = NextFragment()
        nextFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, nextFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun initView() {
        tvNumber = requireActivity().findViewById(R.id.tv_number)
        btnPress = requireActivity().findViewById(R.id.btn_press)
    }
}