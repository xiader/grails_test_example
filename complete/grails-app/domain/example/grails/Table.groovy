package example.grails

import grails.compiler.GrailsCompileStatic
import grails.persistence.Entity


class Table {

    Long id
    String name
    Long participants

    static mapping = {
        version false
        table 'tables'
        id column:'id', generator:'native', params:[sequence:'table_seq']
    }


    static constraints = {
        name nullable: true
        participants nullable: true
    }


}
