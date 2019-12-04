package com.app.shanindu.news.model

import android.os.Parcelable
import java.io.Serializable

class News : Serializable {
    var author: String = ""
    var title: String = ""
    var description: String = ""
    var url: String = ""
    var urlToImage: String = ""
    var publishedAt: String = ""
    var content: String = ""

    constructor() {}

//    constructor(id: String, first_name: String, last_name: String, email: String, avatar: String ) {
//        this.id = id
//        this.first_name = first_name
//        this.last_name = last_name
//        this.email = email
//        this.avatar = avatar
//    }


}


