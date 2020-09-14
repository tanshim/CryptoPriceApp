package com.example.cryptopriceapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        if (!intent.hasExtra(EXTRA_FSYM)) {
            finish()
            return
        }
        val fsym = intent.getStringExtra(EXTRA_FSYM)
        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(CoinViewModel::class.java)
        viewModel.getDetailInfo(fsym).observe(this, Observer {
            tvPrice.text = it.price
            tvMinPrice.text = it.lowDay
            tvMaxPrice.text = it.highDay
            tvLastMarket.text = it.lastMarket
            tvLastUpdate.text = it.getFormattedTime()
            tvFromSymbol.text = it.fromSymbol
            tvToSymbol.text = it.toSymbol
            Picasso.get().load(it.getFullImageURL()).into(ivLogoCoin)
        })
    }

    companion object {
        private const val EXTRA_FSYM = "fsym"

        fun newIntent(context: Context, fsym: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FSYM, fsym)
            return intent
        }
    }
}