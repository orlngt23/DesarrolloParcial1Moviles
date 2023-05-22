package com.example.cervezas
import android.app.Application
import com.example.cervezas.Data.Model.Cervezas
import com.example.cervezas.Repository.Repository

class BeerReviewerApplication {
    val beerRepository: Repository by lazy{
        Repository(Cervezas)
    }
}

