package example.grails

import grails.plugin.springsecurity.annotation.Secured

import org.grails.web.json.JSONObject

@Secured('isAuthenticated()')
class PingController {
    static responseFormats = ['json']

    def jsonManagerService

    def index() {
        JSONObject json = request.getJSON() as JSONObject
        if (!json) {
            render "{inappropriate body format}"
            return
        }
        render jsonManagerService.parseJson(json)
    }
}
