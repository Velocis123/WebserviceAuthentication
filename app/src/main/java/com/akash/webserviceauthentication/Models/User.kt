package com.akash.webserviceauthentication.Models

public class User {

private var id:Int?=null
    private var name:String?=null
    private var email:String?=null
    private var gender:String?=null

    constructor(id: Int?, name: String?, email: String?, gender: String?) {
        this.id = id
        this.name = name
        this.email = email
        this.gender = gender
    }



public fun getId(): Int? {
    return id

}

public fun setId( id: Int?){

    this.id=id

}
    public fun getName(): String? {
        return name

    }

    public fun setName( name: String?){

        this.name=name

    }
    public fun getEmail(): String? {
        return email

    }

    public fun setEmail( email: String?){

        this.email=email

    }
    public fun getGender(): String? {
        return gender

    }

    public fun setGender( gender: String?){

        this.gender=gender

    }




}