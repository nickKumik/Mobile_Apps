package com.example.formulalist

/*
 * Data model class to store logos and team names from F1
 */
class MyModel {
    private lateinit var AuthorName: String
    private lateinit var Date: String
    var modelName: String? = null
    private var modelImage: Int = 0

    /*
     * Return the team name
     */
    fun getNames(): String {
        return modelName.toString()
    }

    /*
     * Set a team name
     */
    fun setAuthor(name: String) {
        this.AuthorName = name
    }

    fun getAuthor(): String {
        return AuthorName.toString()
    }
    fun setDate(name: String) {
        this.Date = name
    }

    fun getDate(): String {
        return Date.toString()
    }

    /*
     * Set a team name
     */
    fun setNames(name: String) {
        this.modelName = name
    }

    /* Return a team logo
     */
    fun getImages(): Int {
        return modelImage
    }

    /* Set a team logo
     */
    fun setImages(image_drawable: Int) {
        this.modelImage = image_drawable
    }
}