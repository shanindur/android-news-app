package com.shanindu.app.news.Model

import java.io.Serializable

class News : Serializable {
    var id: String = ""
    var first_name: String = ""
    var last_name: String = ""
    var email: String = ""
    var avatar: String = ""

    constructor() {}

    constructor(id: String, first_name: String, last_name: String, email: String, avatar: String ) {
        this.id = id
        this.first_name = first_name
        this.last_name = last_name
        this.email = email
        this.avatar = avatar
    }
}


