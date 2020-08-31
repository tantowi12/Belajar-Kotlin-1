package com.example.belajarkotlindasar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarkotlindasar.adapter.ItemAdapter
import com.example.belajarkotlindasar.listener.OnItemClickListener
import com.example.belajarkotlindasar.model.Item
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_home.*

class ExploreFragment : Fragment() {

    lateinit var itemAdapter: ItemAdapter
    val lm = LinearLayoutManager(activity)
    val addItemList: MutableList<Item> = ArrayList()
    var isLoading = false

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

        rv_Item.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > 0 ) {
                    var vItem = lm.childCount
                    var lItem = lm.findFirstCompletelyVisibleItemPosition()
                    var count = itemAdapter.itemCount

                    if (!isLoading) {
                        if (vItem + lItem >= count) {
                            addMoreData()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun addMoreData() {
        isLoading = true
        pb_progress.visibility = View.VISIBLE
        for (i in 0..5) {
            addItemList.add(Item("Ini Buku ke " + i + "", "jdiasdfkasdjnfasdjfnal akdfbaksd aksdjfaksjd aksdfaksjd aksjdfn"))
        }
        Handler().postDelayed({
            isLoading = false
            pb_progress.visibility = View.GONE
            itemAdapter.setItem(addItemList)
        }, 3000)
    }
}