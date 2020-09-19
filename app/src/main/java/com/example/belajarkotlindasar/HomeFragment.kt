package com.example.belajarkotlindasar

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarkotlindasar.adapter.UserAdapter
import com.example.belajarkotlindasar.model.realm.User
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var userAdapter: UserAdapter
    val  lm = LinearLayoutManager(activity)
    lateinit var realm: Realm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        action()
    }


    fun initView() {
        rvHasil.layoutManager = lm
        userAdapter = UserAdapter(activity!!)
        rvHasil.adapter = userAdapter

        realm = Realm.getDefaultInstance()
        getAllUser()
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

        btn_add1.setOnClickListener {
            realm.beginTransaction()
            var count = 0

            realm.where(User::class.java).findAll().let {
                for (i in it) {
                    count++
                }
            }

            try {
                var user = realm.createObject(User::class.java)
                user.setId(count+1)
                user.setNama(et_nama.text.toString())
                user.setEmail(et_email.text.toString())

//                tv_result.text = user.getId().toString() + " " + user.getNama() + "" + user.getEmail()
                getAllUser()
                et_nama.setText("")
                et_email.setText("")

                realm.commitTransaction()
            } catch (e: RealmException) {
                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getAllUser() {
        realm.where(User::class.java).findAll().let {
            userAdapter.setUser(it)
        }
    }
}


