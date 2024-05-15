package com.example.onlineshop.fragments.Explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.onlineshop.R
import com.example.onlineshop.adapters.BestProductAdapter
import com.example.onlineshop.adapters.CategoryAdapter
import com.example.onlineshop.databinding.FragmentExploreBinding
import com.example.onlineshop.models.BestProductModel
import com.example.onlineshop.models.CategoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding: FragmentExploreBinding
        get() = _binding!!

    private val exploreViewModel: ExploreFragmentViewModel by viewModels()

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var bestProductAdapter: BestProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryAdapter()
        bestProduct()
        slideImage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun categoryAdapter() {
        categoryAdapter = CategoryAdapter()

        val cat1 = CategoryModel(R.drawable.cat1, "category 1")
        val cat2 = CategoryModel(R.drawable.cat3, "category 2")
        val cat3 = CategoryModel(R.drawable.cat4, "category 3")
        val cat4 = CategoryModel(R.drawable.cat5, "category 4")
        val cat5 = CategoryModel(R.drawable.cat6, "category 5")

        val list = listOf(cat1, cat2, cat3, cat4, cat5)
        categoryAdapter.submitList(list)
        binding.categoryRecycleView.adapter = categoryAdapter
    }

    private fun bestProduct() {
        bestProductAdapter = BestProductAdapter()

        val p1 = BestProductModel(R.drawable.n1, "a", "$:100", "4.5")
        val p2 = BestProductModel(R.drawable.n2, "b", "$:100", "4.5")
        val p3 = BestProductModel(R.drawable.n3, "c", "$:100", "4.5")
        val p4 = BestProductModel(R.drawable.n4, "d", "$:100", "4.5")
        val p5 = BestProductModel(R.drawable.n5, "d", "$:100", "4.5")
        val p6 = BestProductModel(R.drawable.n6, "d", "$:100", "4.5")

        val list = listOf(p1, p2, p3, p4, p5, p6)

        bestProductAdapter.submitList(list)

        val layoutManager = GridLayoutManager(context, 2)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        binding.bestSellerRecycleView.layoutManager = layoutManager

        binding.bestSellerRecycleView.adapter = bestProductAdapter
    }

    private fun slideImage() {
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                R.drawable.banner1
            )
        )
        imageList.add(
            SlideModel(
                R.drawable.banner2
            )
        )
        imageList.add(SlideModel(R.drawable.banner1))


        binding.imageSlider.setImageList(imageList)

    }
}