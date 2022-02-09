package com.example.qnaproject.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.qnaproject.ProductAdapter
import com.example.qnaproject.R
import com.example.qnaproject.databinding.ActivityProductBinding
import com.example.qnaproject.domain.Product
import com.example.qnaproject.domain.Qna
import com.example.qnaproject.fragment.*
import com.google.android.material.navigation.NavigationBarView

/**
 * 상품 관련 화면
 * 상품 리스트, 상품 등록 등의 작업
 *
 * 바텀네비게이션 뷰
 */
class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

        // Fragment 이동 매니저
        mFragmentManager = supportFragmentManager
        mFragmentManager.beginTransaction().add(binding.mainFrame.id, HomeFragment()).commit()
        setBottomNavigationClickEvent() // bottomNavigation을 통한 fragment 대체
    }

    /**
     * 바텀 네비게이션 아이템 클릭 이벤트 설정
     */
    private fun setBottomNavigationClickEvent() {
        // 바텀 네비게이션 클릭시 fragment 변환
        binding.bnvProduct.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_product_list -> mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, HomeFragment.getInstance()).commit()
                R.id.item_product_register -> mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, RegisterFragment.getInstance()).commit()
                R.id.item_3 -> mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, Fragment3.getInstance()).commit()
                R.id.item_4 -> mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, Fragment4.getInstance()).commit()
                R.id.item_5 -> mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, Fragment5.getInstance()).commit()
            }
            true
        }
    }

    fun changeFragment(flag: String) {

        when(flag) {
            "register" -> {
                mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, RegisterFragment.getInstance()).commit()
            }
            "home" -> {
                mFragmentManager.beginTransaction()
                    .replace(binding.mainFrame.id, HomeFragment.getInstance()).commit()
            }
        }
    }

}