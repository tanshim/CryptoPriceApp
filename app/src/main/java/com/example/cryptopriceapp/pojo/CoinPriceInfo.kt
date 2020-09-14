package com.example.cryptopriceapp.pojo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptopriceapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptopriceapp.utils.convertTimestampToTime
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    val market: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    val flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: String? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: String? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: String? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    val lastVolumeTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: String? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: String? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24Hour: String? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: String? = null,

    @SerializedName("OPENDAY")
    @Expose
    val openDay: String? = null,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: String? = null,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: String? = null,

    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: String? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    val high24Hour: String? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    val low24Hour: String? = null,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24Hour: String? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: String? = null,

    @SerializedName("SUPPLY")
    @Expose
    val supply: Int? = null,

    @SerializedName("MKTCAP")
    @Expose
    val mktCap: String? = null,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolume24H: String? = null,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolume24HTo: String? = null,

    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String? = null
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageURL(): String {
        return BASE_IMAGE_URL + imageURL
    }
}