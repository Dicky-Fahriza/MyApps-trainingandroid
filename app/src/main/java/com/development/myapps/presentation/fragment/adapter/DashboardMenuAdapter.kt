package com.development.myapps.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.development.myapps.R
import com.development.myapps.model.MenuDashboard
import com.development.myapps.model.MenuDashboardModel
import dagger.hilt.android.AndroidEntryPoint


class DashboardMenuAdapter(
    private val menuData: List<MenuDashboard>,
    private val context: Context
) : BaseAdapter() {
    private var image: ImageView? = null
    private var textMenu: TextView? = null
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return menuData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var bindingView = convertView

        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (bindingView == null ) {
            bindingView = layoutInflater?.inflate(R.layout.item_menu_dashboard, null)
        }

        image = bindingView?.findViewById(R.id.ivMenu)
        textMenu = bindingView?.findViewById(R.id.tvMenu)

        // Fungsi untuk mendapatkan data dari list berdasarkan posisi
        val resultMenu = menuData[position]

        // Fungsi untuk melakukan set pada masing-masing component di layout
//        image?.setImageResource(resultMenu.image)
        textMenu?.text = resultMenu.nameMenu
        return bindingView
    }



}