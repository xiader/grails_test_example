package example.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*

@Secured('isAuthenticated()')
class TableController {

    TableService tableService

    JsonManagerService jsonManagerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def denied() {
        render(view: '/denied')
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def resp = jsonManagerService.getAllAdapt()
        respond resp
       //respond tableService.list(params), model:[tableCount: tableService.count()]
    }

    def show(Long id) {
        respond tableService.get(id)
    }

    def create() {
        respond new Table(params)
    }

    def save() {
     /*   if (object == null) {
            notFound()
            return
        }*/
        println ()
        try {
            def json = jsonManagerService.parseJson(request.getJSON() as JSONObject)
            respond json
        } catch (ValidationException e) {
           // respond object.errors, view:'create'
            return
        }

//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'table.label', default: 'Table'), table.id])
//                redirect table
//            }
//            '*' { respond table, [status: CREATED] }
//        }
    }

    def edit(Long id) {
        respond tableService.get(id)
    }
/*
    def update(Table table) {
        if (table == null) {
            notFound()
            return
        }

        try {
            tableService.save(table)
        } catch (ValidationException e) {
            respond table.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'table.label', default: 'Table'), table.id])
                redirect table
            }
            '*'{ respond table, [status: OK] }
        }
    }*/


    def update() {
        try {
            def json = jsonManagerService.parseJson(request.getJSON() as JSONObject)
            respond json
        } catch (ValidationException e) {
            // respond object.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'table.label', default: 'Table'), table.id])
                redirect table
            }
            '*'{ respond table, [status: OK] }
        }
    }


    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'table.label', default: 'Table'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'table.label', default: 'Table'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
