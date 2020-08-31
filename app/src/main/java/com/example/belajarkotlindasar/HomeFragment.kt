package com.example.belajarkotlindasar

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarkotlindasar.adapter.ItemAdapter
import com.example.belajarkotlindasar.listener.OnItemClickListener
import com.example.belajarkotlindasar.model.Item
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        action()
    }

    fun action() {
        btn_ad.setOnClickListener {
            var b = AlertDialog.Builder(activity)
            b.setTitle("Ini akan pindah halaman")
            b.setMessage("Apakah anda yakin?")
            b.setPositiveButton("Yes", {dialogInterface: DialogInterface?, i: Int ->
                var i = Intent(activity, MainActivity::class.java)
                startActivity(i)
            })

            b.setNegativeButton("No", {dialogInterface: DialogInterface?, i: Int ->  })
            b.show()

            }

        btn_toast.setOnClickListener {
            Toast.makeText(activity, "Ini Toast", Toast.LENGTH_LONG).show()
        }
    }

}


