package com.example.cervezas.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cervezas.Data.Model.ModelBeer
import com.example.cervezas.BeerReviewerApplication
import com.example.cervezas.Repository.Repository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.cervezas.Data.Model.brand
import com.example.cervezas.Data.Model.type
const val BEER_ADD  = "Beer added to database"
const val WRONG_INFORMATION = "Wrong information"
const val INACTIVE = ""


class BeerViewModel(private val repsoitory: Repository): ViewModel() {
    val Brand = MutableLiveData("")
    val Type = MutableLiveData("")
    val status = MutableLiveData("")

    fun getBeer () = repsoitory.getBeers()

    private fun addBeer (beer: ModelBeer) = repsoitory.setBeer(beer)

    private fun validationData(): Boolean{
        when{


           Brand.value.isNullOrBlank() -> return false
            Type.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun createBeer(): String{
        if(!validationData()){
            status.value = WRONG_INFORMATION
//            return WRONG_INFORMATION
        }
        val beer = ModelBeer(
            brand = Brand.value!!,
            type = Type.value!!,
        )
        addBeer(beer)
        status.value = BEER_ADD
        return BEER_ADD
    }
    fun clearData(){
        Brand.value = ""
        Type.value = ""
    }
    fun clearStatus (){
        status.value = INACTIVE
    }

    fun setSelectedBeer(beer: ModelBeer){
        Brand.value = beer.brand
        Type.value = beer.type
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val beerRepo = (this[APPLICATION_KEY] as BeerReviewerApplication).beerRepository
                BeerViewModel(beerRepo)
            }
        }


    }
}






