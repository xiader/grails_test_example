package example.grails

import org.springframework.http.HttpStatus

trait ResponseSender {

    void sendResponse() {
        render status: HttpStatus.NO_CONTENT
    }

    void sendResponse(def responseData) {
        respond (responseData)
    }

    void sendResponse(HttpStatus status, def responseData) {
        response.status = status.value()
        respond (responseData)
    }
}