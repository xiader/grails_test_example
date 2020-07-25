package example.grails

import example.grails.NonDeleteRestfulController
import grails.rest.Resource


@Resource(uri = '/users', superClass = NonDeleteRestfulController, formats=['json', 'xml'])
class User2 {

    Long id
    String username
    String lastname
    String firstname
    String email

    static mapping = {
        version: false
        table: 'users'
        id column: 'id', generator:'native', params:[sequence:'user_seq']
    }


    static constraints = {
        email email: true
        lastname nullable: true
        firstname nullable: true
    }

}