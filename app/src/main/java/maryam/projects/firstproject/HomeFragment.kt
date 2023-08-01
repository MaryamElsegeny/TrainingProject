package maryam.projects.firstproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var homeView: View
    private lateinit var homeRecycler : RecyclerView
    private var homeAdapter = HomeAdapter()
    private var homeList: ArrayList<HomeData>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeView = inflater.inflate(R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        return homeView}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        addData()
        initHomeRecycler()
    }

    private fun initViews(){
        homeRecycler = homeView.findViewById(R.id.homeRv)
    }

    private fun addData(){
        homeList?.add(HomeData(R.drawable.city , "First Description"))
        homeList?.add(HomeData(R.drawable.city , "Second Description"))
        homeList?.add(HomeData(R.drawable.city , "Third Description"))
        homeList?.add(HomeData(R.drawable.city , "Fourth Description"))

    }

    private fun initHomeRecycler(){
        homeAdapter = HomeAdapter(requireContext() , homeList)
        homeRecycler.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL , false)
        homeRecycler.adapter = homeAdapter
    }

}