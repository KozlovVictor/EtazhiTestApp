package ru.kozlov_victor.etazhitestapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.kozlov_victor.etazhitestapp.R
import ru.kozlov_victor.etazhitestapp.mvp.presenter.list.IPropertyListPresenter
import ru.kozlov_victor.etazhitestapp.mvp.view.item.IItemPropertyView

class PropertyRVAdapter(val propertyListPresenter: IPropertyListPresenter) :
    RecyclerView.Adapter<PropertyRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_property,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = propertyListPresenter.getPropertyCount()!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), IItemPropertyView {

        private val propertyPrice = itemView.findViewById<TextView>(R.id.tv_property_price)
        private val propertyAddress = itemView.findViewById<TextView>(R.id.tv_property_address)
        private val propertyShortDesc = itemView.findViewById<TextView>(R.id.tv_property_short_desc)
        private val pos = 0

        override fun getPos(): Int = pos

        override fun setPrice(price: String?) {
            propertyPrice.text = price
        }

        override fun setAddress(address: String?) {
            propertyAddress.text = address
        }

        override fun setShortDesc(description: String?) {
            propertyShortDesc.text = description
        }

        fun bind(position: Int) = itemView.setOnClickListener{
            propertyListPresenter.onItemClick(position)
        }
    }
}