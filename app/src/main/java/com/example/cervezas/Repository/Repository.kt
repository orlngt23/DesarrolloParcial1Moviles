package com.example.cervezas.Repository

import com.example.cervezas.Data.Model.ModelBeer

class Repository (private val beers: MutableList<ModelBeer>){
   fun getBeers () = beers
   fun setBeer (beer: ModelBeer) = beers.add(beer)
}


