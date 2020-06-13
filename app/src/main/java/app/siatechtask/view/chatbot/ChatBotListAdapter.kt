package app.siatechtask.view.chatbot

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.siatechtask.R
import app.siatechtask.databinding.ItemChatBotListBinding
import app.siatechtask.models.AnswerResponse
import java.util.*

/**
 * A custom adapter to use with the RecyclerView widget.
 */
class ChatBotListAdapter(private val mContext: Context, private var modelList: ArrayList<AnswerResponse>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(modelList: ArrayList<AnswerResponse>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

    fun addDataToExist(mDataSet: AnswerResponse) {
        this.modelList.add(mDataSet)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int): ViewHolder {
        val binding: ItemChatBotListBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.item_chat_bot_list, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int) {

        //Here you can fill your row view
        if (holder is ViewHolder) {
            val model = getItem(position)
            holder.bind(model)
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    private fun getItem(position: Int): AnswerResponse {
        return modelList[position]
    }

    inner class ViewHolder(val binding: ItemChatBotListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: AnswerResponse){
            binding.chatItem = model
           // binding.view = binding.img
            binding.executePendingBindings()

        }
    }

}