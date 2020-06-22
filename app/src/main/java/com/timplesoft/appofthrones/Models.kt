package com.timplesoft.appofthrones

import java.util.*

data class Character(
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var born: String,
    var title: String,
    var actor: String,
    var quote: String,
    var father: String,
    var mother: String,
    var spouse: String,
    var img: String,
    var house: House
)

data class House(var name: String, var region: String, var words: String, var img: String) {

    companion object {

        private val DEFAULT_PALLETE = arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_stark)

        private val resources = mapOf(
            Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_stark)),
            Pair("lannister", arrayOf(R.color.lannisterOVerlay, R.color.lannisterBase, R.drawable.ic_lannister)),
            Pair("tyrell", arrayOf(R.color.tyrellOVerlay, R.color.tyrellBase, R.drawable.ic_tyrell)),
            Pair("arryn", arrayOf(R.color.arrynOVerlay, R.color.arrynBase, R.drawable.ic_arryn)),
            Pair("targaryen", arrayOf(R.color.targaryenOVerlay, R.color.targaryenBase, R.drawable.ic_targaryen)),
            Pair("martell", arrayOf(R.color.martellOVerlay, R.color.martellBase, R.drawable.ic_martell)),
            Pair("baratheon", arrayOf(R.color.baratheonOVerlay, R.color.baratheonBase, R.drawable.ic_baratheon)),
            Pair("greyjoy", arrayOf(R.color.greyjoyOVerlay, R.color.greyjoyBase, R.drawable.ic_greyjoy)),
            Pair("frey", arrayOf(R.color.freyOVerlay, R.color.freyBase, R.drawable.ic_frey)),
            Pair("tully", arrayOf(R.color.turryOVerlay, R.color.tullyBase, R.drawable.ic_tully))
        )

        fun getOverlayColor(houseId: String): Int {
            val pallete: Array<Int> = resources.getOrDefault(houseId, DEFAULT_PALLETE)
            return pallete[0]
        }

        fun getBaseColor(houseId: String): Int {
            val pallete: Array<Int> = resources.getOrDefault(houseId, DEFAULT_PALLETE)
            return pallete[1]
        }

        fun getIcon(houseId: String): Int {
            val pallete: Array<Int> = resources.getOrDefault(houseId, DEFAULT_PALLETE)
            return pallete[2]
        }

    }

}
