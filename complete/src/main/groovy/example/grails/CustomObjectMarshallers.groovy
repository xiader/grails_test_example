package example.grails

class CustomObjectMarshallers {

    List marshallers = []

    void register() {
        marshallers.each {
            it.register()
        }
    }
}