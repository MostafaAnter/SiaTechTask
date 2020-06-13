package app.siatechtask.view.chatbot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import app.siatechtask.R
import app.siatechtask.databinding.FragmentChatBotBinding
import app.siatechtask.models.AnswerResponse
import app.siatechtask.utils.Helper
import app.siatechtask.utils.ViewBounceAnimation
import app.siatechtask.viewModel.AnswersViewModel
import app.siatechtask.viewModel.CustomAnswersViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ChatBotFragment : Fragment() {

    private var mAdapter: ChatBotListAdapter? = null
    private val modelList = ArrayList<AnswerResponse>()

    // layout manager that use in scroll to last item
    private lateinit var layoutManager: LinearLayoutManager

    // set binding
    private lateinit var binding: FragmentChatBotBinding

    // for view model
    val model: AnswersViewModel by viewModels {
        CustomAnswersViewModelFactory("")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_bot, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

        // initViewModel
        initThenObserveViewModel()

        // handel send button
        binding.sendButton.setOnClickListener {
            if (binding.commentText.text.toString().isNotBlank()){
                it.startAnimation(ViewBounceAnimation.bounceAnimation(requireActivity()))
                mAdapter?.addDataToExist(AnswerResponse(answer = binding.commentText.text.toString()))
                model.refreshData(binding.commentText.text.toString())
                binding.commentText.setText("")
                Helper.hideSoftKeyboard(requireActivity(), binding.commentText)

                // scroll to bottom
                layoutManager.scrollToPosition(mAdapter?.itemCount?.minus(1)?: 2 )
            }

        }
    }

    private fun setAdapter() {
        mAdapter = ChatBotListAdapter(requireActivity(), modelList)
        binding.recyclerView.setHasFixedSize(true)

        // use a linear layout manager
        layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = mAdapter
    }

    private fun initThenObserveViewModel() {
        model.getDataRepository()?.observe(requireActivity(), Observer {
            if (it != null){
                // if u subscribe it will work perfect
                mAdapter?.addDataToExist(it)
            }else{
                // for test without subscription
                mAdapter?.addDataToExist(AnswerResponse(image = "https://spoonacular.com/cdn/ingredients_100x100/apple.jpg", answer = "\"There are 16.74 mg of Vitamin C in 2 apples. This covers about 20% of your daily needs of Vitamin C."))
            }

            // scroll to bottom
            layoutManager.scrollToPosition(mAdapter?.itemCount?.minus(1)?: 2 )

        })
    }
}