package com.example.cryptopriceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptopriceapp.adapters.CoinInfoAdapter
import com.example.cryptopriceapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_list.*

class CoinListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun OnCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent =
                    CoinDetailActivity.newIntent(this@CoinListActivity, coinPriceInfo.fromSymbol)
                startActivity(intent)
            }
        }
        rvCoinList.adapter = adapter
        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(CoinViewModel::class.java)
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
    }
}