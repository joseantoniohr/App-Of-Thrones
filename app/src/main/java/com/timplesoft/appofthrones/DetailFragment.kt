package com.timplesoft.appofthrones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.data_character.*
import kotlinx.android.synthetic.main.header_character.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(id: String): DetailFragment {
            val instance = DetailFragment()

            val args = Bundle()
            args.putString("key_id", id)

            instance.arguments = args

            return instance
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments!!.getString("key_id")
        val character = CharactersRepo.findCharacterById(id!!)

        btnHouse.setOnClickListener {
            Toast.makeText(context, character?.house?.words, Toast.LENGTH_SHORT).show()
        }

        character?.let {
            with ( character ) {
                labelName.text = name
                labelTitle.text = title
                labelActor.text = actor
                labelBorn.text = born
                labelParents.text = "${father} & ${mother}"
                labelQuote.text = quote
                labelSpouse.text = spouse

                val overlayColor = House.getOverlayColor(house.name)
                imgOverlay.background = ContextCompat.getDrawable(context!!, overlayColor)

                val baseColor = House.getBaseColor(house.name)
                btnHouse.backgroundTintList = ContextCompat.getColorStateList(context!!, baseColor)

                val icon = House.getIcon(house.name)
                btnHouse.setImageDrawable(ContextCompat.getDrawable(context!!, icon))

                Picasso.get()
                    .load(character.img)
                    .placeholder(R.drawable.test)
                    .into(imgCharacter)

            }
        }

        btnHouse.setOnClickListener {
            if ( character != null ) {
                showDialog(character.house)
            }
        }


    }

    private fun showDialog(house: House) {
        val dialog = HouseDialog.newInstance(house)
        dialog.show(childFragmentManager, "house_dialog")
    }

}
