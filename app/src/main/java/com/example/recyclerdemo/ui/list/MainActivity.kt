package com.example.recyclerdemo.ui.list

import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdemo.ui.list.recycler.MyAdapter
import com.example.recyclerdemo.R
import com.mikepenz.itemanimators.SlideRightAlphaAnimator
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity() : DaggerAppCompatActivity() {
      @Inject  lateinit var adapter: MyAdapter
      @Inject  lateinit  var arrayListOf: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // không có khởi tạo 2 biến adapter arrayListof mà dùng dùng dc đây luôn
        recycler.adapter = adapter // cach 2
        recycler.layoutManager = LinearLayoutManager(this)



        // item touch helper
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition

                arrayListOf[from] = arrayListOf[to].also { arrayListOf[to] = arrayListOf[from] }
                adapter.notifyItemMoved(from,to)


                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction) {
                    ItemTouchHelper.RIGHT -> { arrayListOf.removeAt(viewHolder.adapterPosition)
                        adapter.deleteAt(viewHolder.adapterPosition) }
                    ItemTouchHelper.LEFT -> { Toast.makeText(applicationContext,"Ban vua vuot trai",Toast.LENGTH_SHORT).show()

                        var position = viewHolder.adapterPosition
                    adapter.notifyDataSetChanged() // thong bao cap nhat giao dien tai vi tri ...
                    }
                }
            }
        }).attachToRecyclerView(recycler)



        swipelayout.setOnRefreshListener {

            Handler().postDelayed( {
                arrayListOf.add(0,"Dong dau")
                arrayListOf.add(arrayListOf.size-1,"Dong cuoi")

                adapter.notifyItemInserted(0)
                adapter.notifyItemInserted(arrayListOf.size-1)

                swipelayout.isRefreshing = false

            } , 2000)

        }


        recycler.itemAnimator = SlideRightAlphaAnimator()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        arrayListOf.add(1,"temp")
        adapter.notifyItemInserted(1)
        return true
    }




}
