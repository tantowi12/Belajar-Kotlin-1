package com.example.belajarkotlindasar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarkotlindasar.adapter.ItemAdapter
import com.example.belajarkotlindasar.listener.OnItemClickListener
import com.example.belajarkotlindasar.model.Item
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_home.*

class ExploreFragment : Fragment() {

    lateinit var itemAdapter: ItemAdapter
    val lm = LinearLayoutManager(activity)
    val addItemList: MutableList<Item> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        detail()

    }

    fun initView() {
        rv_Item.layoutManager = lm
        itemAdapter = ItemAdapter(activity!!)
        rv_Item.adapter = itemAdapter

        addItemList.add(Item("Ini Buku 1", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 2", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 3", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 4", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 5", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 6", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 7", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 8", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 9", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 10", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        addItemList.add(Item("Ini Buku 11", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))


        itemAdapter.setItem(addItemList)
    }

    fun detail() {
        itemAdapter.setonClickItemListener(object : OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, DetailItem::class.java)
                i.putExtra("title", itemAdapter.getItems().get(position).getTitle() )
                i.putExtra("description", itemAdapter.getItems().get(position).getDescription())
                startActivity(i)
            }

        })
    }



}