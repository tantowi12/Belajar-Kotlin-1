package com.example.belajarkotlindasar.model

class Item {

    private var title : String = ""
    private var description : String = ""

    constructor(title: String, descripton: String) {
        this.title = title
        this.description = descripton
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(descripton: String) {
        this.description = description
    }


}