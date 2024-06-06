package com.edu.grupo6.parcial_tp3_2024.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.edu.grupo6.parcial_tp3_2024.R
import com.edu.grupo6.parcial_tp3_2024.database.AppDatabase
import com.edu.grupo6.parcial_tp3_2024.database.Favorite
import com.edu.grupo6.parcial_tp3_2024.database.favoriteDao
import com.google.android.material.snackbar.Snackbar


class OffersFragment : Fragment() {

    private lateinit var view : View

    private var db: AppDatabase? = null
    private var favDao : favoriteDao? = null

    private lateinit var favMasterCard : ImageView
    private lateinit var favVisaCard : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_offers, container, false)

        db = AppDatabase.getAppDatabase(view.context)
        favDao = db?.favoriteDao()

        val fav = Favorite(1, "20% Mastercard", "Credit card")
        favDao?.insertFavorite(fav)


        favMasterCard = view.findViewById(R.id.favIconMaster)
        favVisaCard = view.findViewById(R.id.favIconVisa)


        favMasterCard.setOnClickListener(){

            var saved = favDao?.getFavoriteById(1)
            val snackbar : Snackbar

            if(saved != null){
                favDao?.delete(saved)
                snackbar = Snackbar.make(view, "Eliminado de favoritos", Snackbar.LENGTH_LONG)
                favMasterCard.setImageResource(R.drawable.favorite)
            } else {
                favDao?.insertFavorite(Favorite(1, "20% Mastercard", "Credit card"))
                snackbar = Snackbar.make(view, "Guardado en favoritos", Snackbar.LENGTH_LONG)
                favMasterCard.setImageResource(R.drawable.favorite_filled)
            }

            snackbar.show()
        }

        favVisaCard.setOnClickListener(){

            var saved = favDao?.getFavoriteById(2)
            val snackbar : Snackbar

            if(saved != null){
                favDao?.delete(saved)
                snackbar = Snackbar.make(view, "Eliminado de favoritos", Snackbar.LENGTH_LONG)
                favVisaCard.setImageResource(R.drawable.favorite)
            } else {
                favDao?.insertFavorite(Favorite(2, "25% Visa", "Debit card"))
                snackbar = Snackbar.make(view, "Guardado en favoritos", Snackbar.LENGTH_LONG)
                favVisaCard.setImageResource(R.drawable.favorite_filled)
            }

            snackbar.show()
        }

        return view
    }

}