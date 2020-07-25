package example.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus

/**
 * Custom RestfulController where we disable the delete action.
 */

@CompileStatic
@Secured('isAuthenticated()')
class NonDeleteRestfulController<T> extends RestfulController<T> {

    // We need to provide the constructors, so the
    // Resource transformation works.
    NonDeleteRestfulController(Class<T> domainClass) {
        this(domainClass, false)
    }

    NonDeleteRestfulController(Class<T> domainClass, boolean readOnly) {
        super(domainClass, readOnly)
    }

    @Override
    def delete() {
        // Return Method not allowed HTTP status code.
        render status: HttpStatus.METHOD_NOT_ALLOWED
    }

    @Override
    Object save() {
        return super.save()
    }

    @Override
    Object index(Integer max) {
        return super.index(max)
    }
}